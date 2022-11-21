package com.dream.universe.space.command.application.service;

import com.dream.universe.friend.command.application.dao.FriendDAO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.command.application.dao.SpaceDAO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.domain.model.Space;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

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

    public Space mapInsert(String accessToken, SpaceDTO spaceDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Space space = new Space();
        space.setMemberCode(memberDTO.getMemberCode());
        space.setSpaceMapinfo(spaceDTO.getSpaceMapinfo());
        space.setSpaceName("temp");
        space.setSpaceIntro("temp");
        space.setSpaceLike(0);
        space.setSpaceReport(0);
        space.setSpaceWarning(0);

        spaceDAO.save(space);

        return space;
    }

    public long spaceInsert(SpaceDTO spaceDTO) {

        Optional<Space> oSpace = spaceDAO.findById(spaceDTO.getSpaceCode());

        Space space = oSpace.get();
        space.setSpaceName(spaceDTO.getSpaceName());
        space.setSpaceIntro(spaceDTO.getSpaceIntro());
        space.setSpacePassword(spaceDTO.getSpacePassword());
        space.setSpaceTag1(spaceDTO.getSpaceTag1());
        space.setSpaceTag2(spaceDTO.getSpaceTag2());
        space.setSpaceTag3(spaceDTO.getSpaceTag3());

        spaceDAO.save(space);

        return space.getSpaceCode();

    }

    public String thumbnailInsert(SpaceDTO spaceDTO) {
        Optional<Space> oSpace = spaceDAO.findById(spaceDTO.getSpaceCode());

        Space space = oSpace.get();
        space.setSpaceThumbnail(spaceDTO.getSpaceThumbnail());

        spaceDAO.save(space);

        return space.getSpaceThumbnail();
    }
}
