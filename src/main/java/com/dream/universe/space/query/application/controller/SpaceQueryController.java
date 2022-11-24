package com.dream.universe.space.query.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.query.application.service.SpaceQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/music")
    public ResponseEntity<ResponseDTO> findMusicById(@RequestHeader(value="spaceCode")  String spaceCode){
        System.out.println("음악 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "음악 정보 조회 성공", spaceQueryService.findMusicById(spaceCode)));
    }

    @GetMapping("/recommend")
    public ResponseEntity<ResponseDTO> findRecommendSpace(@RequestBody SpaceDTO spaceDTO){
        System.out.println("추천 스페이스 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스페이스 정보 조회 성공", spaceQueryService.findAllRecommend(spaceDTO.getSpaceType())));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> searchSpace(@RequestBody SpaceDTO spaceDTO){
        System.out.println("스페이스 검색 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스페이스 검색 성공", spaceQueryService.searchAllSpace(spaceDTO.getSpaceName())));
    }
}
