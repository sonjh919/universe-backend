package com.dream.universe.photo.query.application.service;

import com.dream.universe.photo.query.application.dao.PhotoQueryDAO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.photo.domain.model.Photo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoQueryService {

    private final TokenProvider tokenProvider;
    private final MemberMapper memberMapper;
    public final PhotoQueryDAO photoQueryDAO;

    public PhotoQueryService(MemberMapper memberMapper, TokenProvider tokenProvider, PhotoQueryDAO photoQueryDAO){
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
        this.photoQueryDAO = photoQueryDAO;
    }
    public List<Photo> findAllById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Photo> photo = photoQueryDAO.findAllByMemberCode(member.getMemberCode());

        System.out.println("photo = " + photo);
        return photo;
    }
}
