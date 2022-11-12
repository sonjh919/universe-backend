package com.dream.universe.space.command.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.command.application.service.SpaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/spaces")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {this.spaceService = spaceService;}

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insert(@RequestHeader(value="Authorization")  String accessToken, @RequestBody SpaceDTO spaceDTO){
        System.out.println("스페이스 등록 API");
        System.out.println("spaceDTO = " + spaceDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "친구요청 성공", spaceService.insert(accessToken, spaceDTO)));
    }



//    @PostMapping("/thumbnail")
//    public ResponseEntity<ResponseDTO> thumbnail(@RequestHeader(value="Authorization")  String accessToken, @RequestBody MemberDTO memberDTO){
//        System.out.println("썸네일 등록 API");
//        System.out.println("memberDTO = " + memberDTO);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "친구요청 성공", spaceService.thumbnail(accessToken, memberDTO)));
//    }
}
