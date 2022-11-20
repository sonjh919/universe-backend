package com.dream.universe.space.command.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.command.application.service.SpaceS3Service;
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

    static private SpaceS3Service spaceS3Service;

    public SpaceController(SpaceService spaceService, SpaceS3Service spaceS3Service) {
        this.spaceService = spaceService;
        this.spaceS3Service = spaceS3Service;
    }

    @PostMapping("/maps/upload")
    public ResponseEntity<ResponseDTO> uploadMap(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @RequestHeader(value="Authorization")  String accessToken){
        System.out.println("맵 등록 API");
        SpaceDTO spaceDTO = new SpaceDTO();
        spaceDTO.setSpaceMapinfo(spaceS3Service.uploadFileV1(multipartFile));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "맵 추가 성공", spaceService.insert(accessToken, spaceDTO)));
    }

//    @PutMapping("/upload")
//    public ResponseEntity<ResponseDTO> insert(@RequestHeader(value = "Authorization") String accessToken, @RequestBody SpaceDTO spaceDTO) {
//        System.out.println("스페이스 등록 API");
//        System.out.println("spaceDTO = " + spaceDTO);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "친구요청 성공", spaceService.insert(accessToken, spaceDTO)));
//    }


}
