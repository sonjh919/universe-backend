package com.dream.universe.member.dao;


import com.dream.universe.member.dto.ItemDTO;
import com.dream.universe.member.dto.MajorDTO;
import com.dream.universe.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public MemberDTO findByEmail(String email);

    public int insertMember(MemberDTO memberDTO);
    public int insertMajor(MajorDTO majorDTO);

    public int insertItem(ItemDTO itemDTO);

    Optional<MemberDTO> findByMemberId(String memberId);

    MemberDTO findById(String memberId);

    int updateMember(MemberDTO memberDTO);

    int deleteMember(String memberId);

    MemberDTO findId(MemberDTO memberDTO);


    MemberDTO doubleCheckEmail(String email);
    MemberDTO doubleCheckNickName(String nickname);

    int updateCherry(MemberDTO memberDTO);

    int updateCap(MemberDTO memberDTO);

    int updateMajor(MajorDTO majorDTO);

    int updateItem(ItemDTO itemDTO);

    MajorDTO findMajorByCode(Long memberCode);

    ItemDTO findItemByCode(Long memberCode);
}

