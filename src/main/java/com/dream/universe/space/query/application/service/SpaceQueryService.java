package com.dream.universe.space.query.application.service;

import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.domain.model.Space;
import com.dream.universe.space.query.application.dao.SpaceQueryDAO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceQueryService {

    private final TokenProvider tokenProvider;
    private final MemberMapper memberMapper;
    public final SpaceQueryDAO spaceQueryDAO;

    public SpaceQueryService(MemberMapper memberMapper, TokenProvider tokenProvider, SpaceQueryDAO spaceQueryDAO){
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
        this.spaceQueryDAO = spaceQueryDAO;
    }

    public List<Space> findAllById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Space> space = spaceQueryDAO.findAllByMemberCode(member.getMemberCode());

        System.out.println("space = " + space);
        return space;
    }

    public List<Space> findAllRecommend() {
        List<Space> space = spaceQueryDAO.findAll(Sort.by(Sort.Direction.DESC, "spaceLike","spaceBookmark"));

        if(space.size()>11){
            int i=space.size()-1;
            while(i>11){
                space.remove(i);
                i--;
            }
        }
        System.out.println("space = " + space);
        return space;
    }
}
