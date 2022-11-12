package com.dream.universe.space.command.application.service;

import com.dream.universe.friend.command.application.dao.FriendDAO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.command.application.dao.SpaceDAO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.domain.model.Space;
import org.springframework.stereotype.Service;

@Service
public class SpaceService {

    public final SpaceDAO spaceDAO;

    private final MemberMapper memberMapper;
    public final TokenProvider tokenProvider;

    public SpaceService(SpaceDAO spaceDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.spaceDAO = spaceDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public long insert(String accessToken, SpaceDTO spaceDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        Space space = new Space();
        // 추가
        spaceDAO.save(space);

        return space.getSpaceCode();

    }

    public long insertMap(String accessToken, SpaceDTO spaceDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        Space space = new Space();
        // 추가
        spaceDAO.save(space);

        return space.getSpaceCode();

    }
}
