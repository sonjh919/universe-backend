package com.dream.universe.like.command.application.service;

import com.dream.universe.like.command.application.dao.LikeDAO;
import com.dream.universe.like.command.application.dto.LikeDTO;

import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.like.command.domain.model.Like;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.command.application.dao.SpaceDAO;
import com.dream.universe.space.domain.model.Space;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    public final LikeDAO LikeDAO;
    public final SpaceDAO spaceDAO;

    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public LikeService(LikeDAO LikeDAO, SpaceDAO spaceDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.LikeDAO = LikeDAO;
        this.spaceDAO = spaceDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public long insert(String accessToken, LikeDTO likeDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Like like = new Like();
        like.setMemberCode(memberDTO.getMemberCode());
        like.setSpaceCode(likeDTO.getSpaceCode());


        Optional<Space> oSpace = spaceDAO.findById(likeDTO.getSpaceCode());
        Space space = oSpace.get();
        space.setSpaceLike(space.getSpaceLike()+1);

        LikeDAO.save(like);
        spaceDAO.save(space);

        return like.getLikeCode();
    }


    public Long delete(Long LikeCode) {
        Optional<Like> oLike = LikeDAO.findById(LikeCode);
        Like like = oLike.get();

        Optional<Space> oSpace = spaceDAO.findById(like.getSpaceCode());
        Space space = oSpace.get();
        space.setSpaceLike(space.getSpaceLike()-1);

        LikeDAO.deleteById(LikeCode);
        spaceDAO.save(space);
        return LikeCode;
    }
}
