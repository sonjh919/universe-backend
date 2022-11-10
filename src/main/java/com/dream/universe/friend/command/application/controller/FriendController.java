package com.dream.universe.friend.command.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.friend.command.application.dto.FreindRequestDTO;
import com.dream.universe.friend.command.application.dto.FriendDTO;
import com.dream.universe.friend.command.application.service.FriendService;
import com.dream.universe.friend.domain.model.Friend;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dto.MajorDTO;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.SourceVersion;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Member;
import java.text.ParseException;
import java.util.Enumeration;

@RestController
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {this.friendService = friendService;}


    @PostMapping("/request")
    public ResponseEntity<ResponseDTO> request(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
        System.out.println("친구요청 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "친구요청 성공", friendService.request(accessToken, memberDTO)));
    }

    @PostMapping("/result")
    public ResponseEntity<ResponseDTO> result(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
        System.out.println("친구요청결과 API");
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "친구요청 성공", friendService.request(accessToken, memberDTO)));
    }

}
