package com.dream.universe.space.query.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.space.query.application.service.SpaceQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spaces")
public class SpaceQueryController {
    private final SpaceQueryService spaceQueryService;

    public SpaceQueryController(SpaceQueryService spaceQueryService){this.spaceQueryService = spaceQueryService;}

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findSpaceById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println("스페이스 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스페이스 정보 조회 성공", spaceQueryService.findAllById(accessToken)));
    }

    @GetMapping("/recommend")
    public ResponseEntity<ResponseDTO> findRecommendSpace(){
        System.out.println("추천 스페이스 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스페이스 정보 조회 성공", spaceQueryService.findAllRecommend()));
    }
}
