package com.dream.universe.photo.command.application.controller;


import com.dream.universe.common.ResponseDTO;
import com.dream.universe.photo.command.application.dto.PhotoDTO;
import com.dream.universe.photo.command.application.service.PhotoS3Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.dream.universe.photo.command.application.service.PhotoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoService photoService;
    static private PhotoS3Service photoS3Service;


    public PhotoController(PhotoService photoService, PhotoS3Service photoS3Service) {
        this.photoService = photoService;
        this.photoS3Service = photoS3Service;
    }

    @PostMapping("/personal/upload")
    public ResponseEntity<ResponseDTO> personalUploadPhoto(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @RequestHeader(value="Authorization")  String accessToken){
        System.out.println("개인 사진 저장 API");
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setPhotoUrl(photoS3Service.uploadFileV1(multipartFile));
        photoDTO.setPhotoType("personal");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "개인 사진 저장 성공", photoService.insert(accessToken, photoDTO)));
    }

    @PostMapping("/work/upload")
    public ResponseEntity<ResponseDTO> workUploadPhoto(
            @RequestPart(value = "file") MultipartFile multipartFile,
            @RequestHeader(value="Authorization")  String accessToken){
        System.out.println("작업용 사진 저장 API");
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setPhotoUrl(photoS3Service.uploadFileV1(multipartFile));
        photoDTO.setPhotoType("work");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "작업용 사진 저장 성공", photoService.insert(accessToken, photoDTO)));
    }

    @DeleteMapping("/delete/{photoCode}")
    public ResponseEntity<ResponseDTO> deletePhoto(@PathVariable Long photoCode){
        System.out.println("사진 삭제 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사진 삭제 성공", photoService.delete(photoCode)));
    }
}
