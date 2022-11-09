package com.dream.universe.member.dao;


import com.dream.universe.member.dto.ChangePwdDTO;
import com.dream.universe.member.dto.MajorDTO;
import com.dream.universe.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public MemberDTO findByEmail(String email);

    public int insertMember(MemberDTO memberDTO);
    public int insertMajor(MajorDTO majorDTO);

    Optional<MemberDTO> findByMemberId(String memberId);

    MemberDTO findById(String memberId);

    int updateMember(MemberDTO memberDTO);

    int deleteMember(String memberId);

    String findId(MemberDTO memberDTO);

    int changePwd(ChangePwdDTO changePwdDTO);

    MemberDTO doubleCheckEmail(String email);
    MemberDTO doubleCheckNickName(String nickname);

    int updateCherry(MemberDTO memberDTO);

    int updateCap(MemberDTO memberDTO);
}

