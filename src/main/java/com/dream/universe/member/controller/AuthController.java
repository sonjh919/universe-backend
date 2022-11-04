package com.dream.universe.member.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.member.dto.MemberDTO;
//import com.dream.universe.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/members")
public class AuthController {

//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }

    @PostMapping("/join")
    public ResponseEntity<ResponseDTO> join(@RequestBody MemberDTO memberDTO) throws ParseException {
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", authService.join(memberDTO)));
        System.out.println(memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", "ex"));
    }

    @PostMapping("/email")
    public ResponseEntity<ResponseDTO> email(@RequestBody String email){

        System.out.println(email);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이메일 중복 확인 성공", "ex"));
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
