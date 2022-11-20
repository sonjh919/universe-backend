package com.dream.universe.space.command.application.controller;

import com.dream.universe.space.command.application.service.SpaceS3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/maps")
public class S3Controller {

    static private SpaceS3Service awsS3Service;

    public S3Controller(SpaceS3Service awsS3Service){
        this.awsS3Service = awsS3Service;
    }

    @PostMapping("/upload")
    public String uploadFile(
            @RequestPart(value = "file") MultipartFile multipartFile) {
        return awsS3Service.uploadFileV1(multipartFile);
    }
}
