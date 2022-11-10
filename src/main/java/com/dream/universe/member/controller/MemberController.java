package com.dream.universe.member.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dto.MajorDTO;
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
        System.out.println("회원 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 정보 조회 성공", memberService.findMemberById(accessToken)));
    }

    @GetMapping("/major")
    public ResponseEntity<ResponseDTO> findMajorById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println("학과 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "학과 정보 조회 성공", memberService.findMajorById(accessToken)));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
        System.out.println("회원 정보 수정 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원정보 수정 성공", memberService.update(accessToken, memberDTO)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete(@RequestHeader(value="Authorization") String accessToken){
        System.out.println("회원 탈퇴 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 탈퇴 성공", memberService.delete(accessToken)));
    }

    @PostMapping("/findId")
    public ResponseEntity<ResponseDTO> findId(@RequestBody MemberDTO memberDTO){
        System.out.println("아이디 조회 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "아이디 조회 성공", memberService.findId(memberDTO)));
    }



    @PutMapping("/cherry/update")
    public ResponseEntity<ResponseDTO> cherryUpdate(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
        System.out.println("체리정보 수정 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "체리정보 수정 성공", memberService.cherryUpdate(accessToken, memberDTO)));
    }

    @PutMapping("/cap/update")
    public ResponseEntity<ResponseDTO> capUpdate(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
        System.out.println("학사모정보 수정 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "학사모정보 수정 성공", memberService.capUpdate(accessToken, memberDTO)));
    }

    @PutMapping("/major/update")
    public ResponseEntity<ResponseDTO> majorUpdate(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MajorDTO majorDTO){
        System.out.println("전공정보 수정 API");
        System.out.println("majorDTO = " + majorDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전공정보 수정 성공", memberService.majorUpdate(accessToken, majorDTO)));
    }

}
