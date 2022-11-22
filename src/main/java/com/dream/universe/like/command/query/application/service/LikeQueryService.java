package com.dream.universe.like.command.query.application.service;


import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.like.command.domain.model.Like;
import com.dream.universe.like.command.query.application.dao.LikeQueryDAO;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeQueryService {
    public final LikeQueryDAO likeQueryDAO;
    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public LikeQueryService(LikeQueryDAO likeQueryDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.likeQueryDAO = likeQueryDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public List<Like> findAllById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Like> like = likeQueryDAO.findAllByMemberCode(member.getMemberCode());

        return like;
    }
}
