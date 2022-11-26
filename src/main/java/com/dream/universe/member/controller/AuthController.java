package com.dream.universe.member.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.member.dto.HateDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.member.service.AuthService;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
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
import java.util.*;

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

    @PostMapping("/hate")
    public ResponseEntity<ResponseDTO> hate(@RequestParam(value = "text") String data)  throws ParseException {
        System.out.println("혐오표현 확인 API");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, String> body
                = new LinkedMultiValueMap<>();
        body.add("text", data);

        HttpEntity<MultiValueMap<String, String>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://34.64.178.50:8000/chat/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        System.out.println("response.getBody() = " + response.getBody());

        String jsonData = (String) response.getBody();
        System.out.println("jsonData = " + jsonData);

        JSONParser parser = new JSONParser();
        Object ob = null;
        try {
            ob = parser.parse(jsonData);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ob = " + ob);

        //타입캐스팅
        JSONObject js = (JSONObject) ob;

        System.out.println("js.get(\"Isclean\") = " + js.get("Isclean"));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "혐오표현 확인 성공", js.get("Isclean")));
    }

    @PostMapping("/card")
    public ResponseEntity<ResponseDTO> idCardImg(@RequestParam("file") MultipartFile idCardImg) throws IOException {
        System.out.println("학생증 인식 & 전공 선택 API");

//        byte[] array = idCardImg.getBytes();
//        System.out.println("length = " + array.length);
//
//        String cardImgFile = Base64.getEncoder().encodeToString(array);
//        String image = UTF8JsonGenerator.

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", idCardImg.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://34.64.194.54:8000/uploadIDCardImage/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        System.out.println("response.getBody() = " + response.getBody());

        String jsonData = (String) response.getBody();
        System.out.println("jsonData = " + jsonData);

        JSONParser parser = new JSONParser();
        Object ob = null;
        try {
            ob = parser.parse(jsonData);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ob = " + ob);

        //타입캐스팅
        JSONObject js = (JSONObject) ob;

        System.out.println("js.get(\"major\") = " + js.get("major"));


        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "이미지 전송 성공", js.get("major")));
    }

    @PostMapping("/art")
    public ResponseEntity<ResponseDTO> artImg(@RequestParam("file") MultipartFile artImg) throws IOException {
        System.out.println("미술작품 추천 API");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body
                = new LinkedMultiValueMap<>();
        body.add("file", artImg.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = "http://34.64.140.135:8000/uploadimg/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        System.out.println("response.getBody() = " + response.getBody());

        String jsonData = (String) response.getBody();
        System.out.println("jsonData = " + jsonData);

        JSONParser parser = new JSONParser();
        Object ob = null;
        try {
            ob = parser.parse(jsonData);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ob = " + ob);

        //타입캐스팅
        JSONObject js = (JSONObject) ob;

        System.out.println("js.get(\"category\") = " + js.get("category"));

        // 디지털페인팅 8 유화 9 펜화 6 소묘 8 수채화 8

        String url = "https://ouruniversebucket.s3.ap-northeast-2.amazonaws.com/ART/";
        String category;
        String number;


        Random rand = new Random();

        if(js.get("category").equals("디지털페인팅")){
            category = "Digital/";
            number = String.valueOf((rand.nextInt(7) + 1));
            url = url + category + number + ".jpg";
            System.out.println("url = " + url);
        }
        else if(js.get("category").equals("유화")){
            category = "Oil/";
            number = String.valueOf((rand.nextInt(8) + 1));
            url = url + category + number + ".jpg";
            System.out.println("url = " + url);
        }
        else if(js.get("category").equals("펜화")){
            category = "Pen/";
            number = String.valueOf((rand.nextInt(5) + 1));
            url = url + category + number + ".jpg";
            System.out.println("url = " + url);
        }
        else if(js.get("category").equals("소묘")){
            category = "Somyo/";
            number = String.valueOf((rand.nextInt(7) + 1));
            url = url + category + number + ".jpg";
            System.out.println("url = " + url);
        }
        else if(js.get("category").equals("수채화")){
            category = "Watercolor/";
            number = String.valueOf((rand.nextInt(7) + 1));
            url = url + category + number + ".jpg";
            System.out.println("url = " + url);
        }

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "미술작품 추천 성공", url));
    }

    @PutMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO){
        System.out.println("로그인 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(memberDTO)));
    }

}
