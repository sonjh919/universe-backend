package com.dream.universe.member.service;


import com.dream.universe.exception.ChangePwdFailedException;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.ItemDTO;
import com.dream.universe.member.dto.MajorDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.dto.MemberInfoDTO;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;

@Service
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }


    @Transactional
    public int update(String accessToken, MemberDTO memberDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        memberDTO.setMemberEmail(memberId);
        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        int result = memberMapper.updateMember(memberDTO);

        return result;
    }

    public MemberDTO findMemberById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);
        System.out.println(member.getMemberEmail());
        return member;
    }

    public int delete(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        int result = memberMapper.deleteMember(memberId);
        return result;
    }

    @Transactional
    public Long cherryUpdate(String accessToken, MemberDTO memberDTO) {

        String memberId = tokenProvider.getUserId(accessToken);
        memberDTO.setMemberEmail(memberId);

        System.out.println("memberDTO service = " + memberDTO);
        int result = memberMapper.updateCherry(memberDTO);

        MemberDTO member = memberMapper.findById(memberId);
        Long Cherry = member.getMemberCherry();
        return Cherry;
    }

    @Transactional
    public Long capUpdate(String accessToken, MemberDTO memberDTO) {

        String memberId = tokenProvider.getUserId(accessToken);
        memberDTO.setMemberEmail(memberId);

        System.out.println("memberDTO service = " + memberDTO);
        int result = memberMapper.updateCap(memberDTO);

        MemberDTO member = memberMapper.findById(memberId);
        Long Cap = member.getMemberCap();
        return Cap;
    }


    public MemberInfoDTO findId(MemberDTO memberDTO) {
        MemberInfoDTO memberInfo = memberMapper.findId(memberDTO);
        return memberInfo;
    }

    @Transactional
    public int majorUpdate(String accessToken, MajorDTO majorDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        System.out.println("memberId = " + memberId);

        MemberDTO memberDTO = memberMapper.findById(memberId);
        majorDTO.setMemberCode(memberDTO.getMemberCode());
        int result = memberMapper.updateMajor(majorDTO);

        return result;
    }

    @Transactional
    public int itemUpdate(String accessToken, ItemDTO itemDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        System.out.println("memberId = " + memberId);

        MemberDTO memberDTO = memberMapper.findById(memberId);
        itemDTO.setMemberCode(memberDTO.getMemberCode());
        int result = memberMapper.updateItem(itemDTO);

        return result;
    }

    public MajorDTO findMajorById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        System.out.println("memberId = " + memberId);

        MemberDTO memberDTO = memberMapper.findById(memberId);


        MajorDTO majorDTO = memberMapper.findMajorByCode(memberDTO.getMemberCode());

        return majorDTO;
    }

    public ItemDTO findItemById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        System.out.println("memberId = " + memberId);

        MemberDTO memberDTO = memberMapper.findById(memberId);
        ItemDTO itemDTO = memberMapper.findItemByCode(memberDTO.getMemberCode());

        return itemDTO;
    }


//    @Transactional
//    public int findPwd(ChangePwdDTO changePwdDTO) {
//
//        MemberDTO member = memberMapper.findByMemberId(changePwdDTO.getMemberId())
//                .orElseThrow(() -> new ChangePwdFailedException("회원 비밀번호 변경을 진행할 수 없습니다. "));
//
//        if(!passwordEncoder.matches(changePwdDTO.getOriginPwd(), member.getPassword())){
//            throw new ChangePwdFailedException("현재 비밀번호가 일치하지 않습니다.");
//        }
//
//        changePwdDTO.setMemberPwd(passwordEncoder.encode(changePwdDTO.getMemberPwd()));
//        int result = memberMapper.changePwd(changePwdDTO);
//
//        return result;
//    }
}