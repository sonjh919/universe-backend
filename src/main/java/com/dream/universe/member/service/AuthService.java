package com.dream.universe.member.service;


import com.dream.universe.exception.DuplicatedMemberIdException;
import com.dream.universe.exception.LoginFailedException;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.dto.TokenDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;


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

//        if(memberMapper.findById(memberDTO.getMemberId()) != null ){
//            throw new DuplicatedMemberIdException("이미 가입된 아이디입니다!");
//        }

//        if(memberMapper.findByEmail(memberDTO.getEmail()) != null ){
//            throw new DuplicatedMemberIdException("이미 가입된 이메일입니다!");
//        }

//        if(memberDTO.getMemberId() == "" || memberDTO.getMemberPwd() == "" || memberDTO.getEmail() == "" || memberDTO.getPhone() == ""){
//            throw new FullInputMemberInfoException("필수 정보를 모두 입력해주세요");
//        }

        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));

        int result = memberMapper.insertMember(memberDTO);
        return memberDTO;
    }

    @Transactional
    public TokenDTO login(MemberDTO memberDTO) {
        MemberDTO member = memberMapper.findByMemberId(memberDTO.getEmail())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디 또는 비밀번호 입니다."));

        System.out.println("member = " + member);
        if(!passwordEncoder.matches(memberDTO.getPassword(), member.getPassword())){
            throw new LoginFailedException("잘못된 아이디 또는 비밀번호 입니다.");
        }

        TokenDTO token = tokenProvider.generateTokenDTO(member);

        return token;
    }

    public boolean doubleCheckEmail(MemberDTO email) {

        if(memberMapper.doubleCheckEmail(email.getEmail()) != null){
            return false;
        }

        return true;
    }
}
