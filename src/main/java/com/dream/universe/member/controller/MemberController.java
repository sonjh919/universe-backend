package com.dream.universe.member.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dto.ChangePwdDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> findMemberById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println(accessToken);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 정보 조회 성공", memberService.findMemberById(accessToken)));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원정보 수정 성공", memberService.update(accessToken, memberDTO)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete(@RequestHeader String accessToken){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 탈퇴 성공", memberService.delete(accessToken)));
    }

    @PostMapping("/findId")
    public ResponseEntity<ResponseDTO> findId(@RequestBody MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "아이디 조회 성공", memberService.findId(memberDTO)));
    }

    @PutMapping("/findPwd")
    public ResponseEntity<ResponseDTO> findPwd(@RequestBody ChangePwdDTO changePwdDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 비밀번호 변경 성공", memberService.findPwd(changePwdDTO)));
    }


}
