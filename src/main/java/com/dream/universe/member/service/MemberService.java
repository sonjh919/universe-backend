package com.dream.universe.member.service;


import com.dream.universe.exception.ChangePwdFailedException;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.ChangePwdDTO;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public int update(MemberDTO memberDTO) {
        int result = memberMapper.updateMember(memberDTO);

        return result;
    }

    public MemberDTO findMemberById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);
        return member;
    }

    public int delete(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        int result = memberMapper.deleteMember(memberId);
        return result;
    }

    public String findId(MemberDTO memberDTO) {
        String memberId = memberMapper.findId(memberDTO);
        return memberId;
    }
    @Transactional
    public int findPwd(ChangePwdDTO changePwdDTO) {

        MemberDTO member = memberMapper.findByMemberId(changePwdDTO.getMemberId())
                .orElseThrow(() -> new ChangePwdFailedException("회원 비밀번호 변경을 진행할 수 없습니다. "));

        if(!passwordEncoder.matches(changePwdDTO.getOriginPwd(), member.getPassword())){
            throw new ChangePwdFailedException("현재 비밀번호가 일치하지 않습니다.");
        }

        changePwdDTO.setMemberPwd(passwordEncoder.encode(changePwdDTO.getMemberPwd()));
        int result = memberMapper.changePwd(changePwdDTO);

        return result;
    }
}