package com.dream.universe.photo.command.application.service;

import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.photo.command.application.dao.PhotoDAO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.photo.command.application.dto.PhotoDTO;
import com.dream.universe.photo.domain.model.Photo;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    public final PhotoDAO photoDAO;
    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public PhotoService(PhotoDAO PhotoDAO, MemberMapper memberMapper, TokenProvider tokenProvider) {
        this.photoDAO = PhotoDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public Long insert(String accessToken, PhotoDTO photoDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Photo photo = new Photo();
        photo.setMemberCode(memberDTO.getMemberCode());
        photo.setPhotoUrl(photoDTO.getPhotoUrl());
        photo.setPhotoType(photoDTO.getPhotoType());

        photoDAO.save(photo);

        return photo.getPhotoCode();
    }

    public Long delete(long photoCode) {
        photoDAO.deleteById(photoCode);
        return photoCode;
    }
}
