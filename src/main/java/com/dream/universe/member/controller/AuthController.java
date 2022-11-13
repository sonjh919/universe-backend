package com.dream.universe.member.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.service.AuthService;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Member;
import java.text.ParseException;
import java.util.Base64;
import java.util.Enumeration;

@RestController
@RequestMapping("/auths")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/join")
    public ResponseEntity<ResponseDTO> join(@RequestBody MemberDTO memberDTO, HttpServletRequest request){
        System.out.println("회원가입 API");
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = (String)headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }

        System.out.println("memberDTO = " + memberDTO);
        
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", authService.join(memberDTO)));
    }

    @PostMapping("/email")
    public ResponseEntity<ResponseDTO> email(@RequestBody MemberDTO email)  throws ParseException {
        System.out.println("이메일 중복 확인 API");
        System.out.println("email = " + email);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이메일 중복 확인 성공", authService.doubleCheckEmail(email)));
    }

    @PostMapping("/nickname")
    public ResponseEntity<ResponseDTO> nickname(@RequestBody MemberDTO memberDTO){
        System.out.println("닉네임 중복 확인 API");
        System.out.println("nickname = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "닉네임 중복 체크", authService.doubleCheckNickName(memberDTO)));
    }

    @PostMapping("/card")
    public ResponseEntity<ResponseDTO> idCardImg(@RequestParam("idCardImg") MultipartFile idCardImg) throws IOException {
        System.out.println("학생증 인식 & 전공 선택 API");

        byte[] array = idCardImg.getBytes();
        System.out.println("length = " + array.length);

        String cardImgFile = Base64.getEncoder().encodeToString(array);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> body
                = new LinkedMultiValueMap<>();
        body.add("file", cardImgFile);

        HttpEntity<MultiValueMap<String, String>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://54.180.154.17:8000/uploadimage/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);


        System.out.println(response.getBody());

        String jsonData = (String) response.getBody();
        System.out.println(jsonData);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이미지 전송 성공", jsonData));
    }

    @PutMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO){
        System.out.println("로그인 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(memberDTO)));
    }

}
