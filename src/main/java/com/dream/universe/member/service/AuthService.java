package com.dream.universe.member.service;


import com.dream.universe.exception.DuplicatedMemberIdException;
import com.dream.universe.exception.LoginFailedException;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MajorDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.dto.TokenDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.sql.SQLOutput;


@Service
public class AuthService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public AuthService(MemberMapper memberMapper, PasswordEncoder passwordEncoder, TokenProvider tokenProvider) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Transactional
    public MemberDTO join(MemberDTO memberDTO) {
        MajorDTO majorDTO = new MajorDTO();
        majorDTO.setMajor(memberDTO.getMemberMajor());

        System.out.println(majorDTO);

        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getPassword()));

        int resultMember = memberMapper.insertMember(memberDTO);
        int resultMajor = memberMapper.insertMajor(majorDTO);
        return memberDTO;
    }

    @Transactional
    public TokenDTO login(MemberDTO memberDTO) {
        System.out.println("memberDTO : " + memberDTO);
        MemberDTO member = memberMapper.findByMemberId(memberDTO.getMemberEmail())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호 입니다."));

        System.out.println("member = " + member);
        if(!passwordEncoder.matches(memberDTO.getPassword(), member.getPassword())){
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호 입니다.");
        }

        TokenDTO token = tokenProvider.generateTokenDTO(member);

        return token;
    }

    public boolean doubleCheckEmail(MemberDTO email) {

        if(memberMapper.doubleCheckEmail(email.getMemberEmail()) != null){
            throw new DuplicatedMemberIdException("이미 가입된 이메일입니다!");
        }

        return true;
    }

    public boolean doubleCheckNickName(MemberDTO memberDTO) {
        if(memberMapper.doubleCheckNickName(memberDTO.getMemberNickName()) != null){
            throw new DuplicatedMemberIdException("중복된 닉네임입니다!");
        }

        return true;
    }
}
