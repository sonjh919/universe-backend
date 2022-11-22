package com.dream.universe.like.command.query.application.controller;


import com.dream.universe.common.ResponseDTO;
import com.dream.universe.like.command.query.application.service.LikeQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikeQueryController {

    private final LikeQueryService likeQueryService;
    public LikeQueryController(LikeQueryService likeQueryService){this.likeQueryService = likeQueryService;}

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findLikeById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println("즐겨찾기 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "즐겨찾기 정보 조회 성공",  likeQueryService.findAllById(accessToken)));

    }
}
