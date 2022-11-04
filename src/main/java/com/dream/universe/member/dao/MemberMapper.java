package com.dream.universe.member.dao;


//import com.dream.universe.member.dto.ChangePwdDTO;
import com.dream.universe.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public MemberDTO findByEmail(String email);

    public int insertMember(MemberDTO memberDTO);

    Optional<MemberDTO> findByMemberId(String memberId);

    MemberDTO findById(String memberId);

    int updateMember(MemberDTO memberDTO);

    int deleteMember(String memberId);

    String findId(MemberDTO memberDTO);

//    int changePwd(ChangePwdDTO changePwdDTO);
}

