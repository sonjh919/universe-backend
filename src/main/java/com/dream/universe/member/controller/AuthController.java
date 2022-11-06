package com.dream.universe.member.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Member;
import java.text.ParseException;

@RestController
@RequestMapping("/auths")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/join")
    public ResponseEntity<ResponseDTO> join(@RequestBody MemberDTO memberDTO) throws ParseException {
        System.out.println(memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", authService.join(memberDTO)));
    }

    @GetMapping("/example")
    public ResponseEntity<ResponseDTO> ex(){
        System.out.println("a");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "예시 확인 성공", "a"));
    }

    @PostMapping("/email")
    public ResponseEntity<ResponseDTO> email(@RequestBody MemberDTO email){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이메일 중복 확인 성공", authService.doubleCheckEmail(email)));
    }

    @PostMapping("/card")
    public ResponseEntity<ResponseDTO> idCardImg(@RequestBody MultipartFile idCardImg) throws IOException {

        byte[] array = idCardImg.getBytes();
        System.out.println(array.length);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이미지 전송 성공", "ex"));
    }

    @PutMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO){
        System.out.println(memberDTO);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(memberDTO)));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", "ex"));
    }

}
