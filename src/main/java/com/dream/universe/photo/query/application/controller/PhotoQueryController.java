package com.dream.universe.photo.query.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.photo.query.application.service.PhotoQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotoQueryController {
    private final PhotoQueryService photoQueryService;

    public PhotoQueryController(PhotoQueryService photoQueryService){this.photoQueryService = photoQueryService;}

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findPhotoById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println("사진 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "친구요청 정보 조회 성공", photoQueryService.findAllById(accessToken)));
    }
}
