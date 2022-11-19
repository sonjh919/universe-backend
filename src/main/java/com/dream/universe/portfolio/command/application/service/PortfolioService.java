package com.dream.universe.portfolio.command.application.service;

import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.portfolio.command.application.dao.PortfolioDAO;
import com.dream.universe.portfolio.command.application.dto.PortfolioDTO;
import com.dream.universe.portfolio.domain.model.Portfolio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {
    public final PortfolioDAO portfolioDAO;

    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public PortfolioService(PortfolioDAO portfolioDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.portfolioDAO = portfolioDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public long insert(String accessToken, PortfolioDTO portfolioDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Portfolio portfolio = new Portfolio();
        portfolio.setMemberCode(memberDTO.getMemberCode());
        portfolio.setPortfolioIndex(portfolioDTO.getPortfolioIndex());
        portfolio.setPortfolioName((portfolioDTO.getPortfolioName()));
        portfolio.setPortfolioLink(portfolioDTO.getPortfolioLink());

        portfolioDAO.save(portfolio);

        return portfolio.getPortfolioCode();
    }

    public long update(String accessToken, PortfolioDTO portfolioDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        System.out.println(memberDTO.getMemberCode());
        System.out.println(portfolioDTO.getPortfolioIndex());

        Optional<Portfolio> oPortfolio = portfolioDAO.findByMemberCodeAndPortfolioIndex(memberDTO.getMemberCode(), portfolioDTO.getPortfolioIndex());

        Portfolio portfolio = oPortfolio.get();
        System.out.println("portfolio = " + portfolio);
        portfolio.setPortfolioName(portfolioDTO.getPortfolioName());
        portfolio.setPortfolioLink(portfolioDTO.getPortfolioLink());

        portfolioDAO.save(portfolio);

        return portfolio.getPortfolioCode();
    }
}
