package com.dream.universe.portfolio.query.application.service;

import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.portfolio.domain.model.Portfolio;
import com.dream.universe.portfolio.query.application.dao.PortfolioQueryDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioQueryService {

    private final TokenProvider tokenProvider;
    private final MemberMapper memberMapper;
    public final PortfolioQueryDAO portfolioQueryDAO;

    public PortfolioQueryService(MemberMapper memberMapper, TokenProvider tokenProvider, PortfolioQueryDAO portfolioQueryDAO){
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
        this.portfolioQueryDAO = portfolioQueryDAO;
    }

    public List<Portfolio> findPortfolioById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Portfolio> portfolios = portfolioQueryDAO.findAllByMemberCode(member.getMemberCode());
        return portfolios;
    }
}
