package com.dream.universe.space.command.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.command.application.service.SpaceS3Service;
import com.dream.universe.space.command.application.service.SpaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



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
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "맵 추가 성공", spaceService.mapInsert(accessToken, spaceDTO)));
    }

    @PutMapping("/maps/update/{spaceCode}")
    public ResponseEntity<ResponseDTO> updateMap(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @PathVariable Long spaceCode){
        System.out.println("맵 수정 API");
        SpaceDTO spaceDTO = new SpaceDTO();
        spaceDTO.setSpaceCode(spaceCode);
        spaceDTO.setSpaceMapinfo(spaceS3Service.uploadFileV1(multipartFile));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "맵 수정 성공", spaceService.mapUpdate(spaceDTO)));
    }

    @PutMapping("/upload")
    public ResponseEntity<ResponseDTO> uploadSpaceInfo(@RequestBody SpaceDTO spaceDTO) {
        System.out.println("스페이스 등록 API");
        System.out.println("spaceDTO = " + spaceDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스페이스 정보 추가 성공", spaceService.spaceInsert(spaceDTO)));
    }

    @PutMapping("/like/update")
    public ResponseEntity<ResponseDTO> uploadLike(@RequestBody SpaceDTO spaceDTO) {
        System.out.println("스페이스 등록 API");
        System.out.println("spaceDTO = " + spaceDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "좋아요 수정 성공", spaceService.likeUpdate(spaceDTO)));
    }

    @PutMapping("/thumbnails/upload/{spaceCode}")
    public ResponseEntity<ResponseDTO> uploadThumbnail(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @PathVariable Long spaceCode){
        System.out.println("썸네일 등록 API");
        SpaceDTO spaceDTO = new SpaceDTO();
        spaceDTO.setSpaceCode(spaceCode);
        spaceDTO.setSpaceThumbnail(spaceS3Service.uploadFileV1(multipartFile));
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "썸네일 추가 성공", spaceService.thumbnailInsert(spaceDTO)));
    }

    @DeleteMapping("/delete/{spaceCode}")
    public ResponseEntity<ResponseDTO> deleteSpace(@PathVariable Long spaceCode){
        System.out.println("스페이스 삭제 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "스페이스 삭제 성공", spaceService.delete(spaceCode)));
    }


}
