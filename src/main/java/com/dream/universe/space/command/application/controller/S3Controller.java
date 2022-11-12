//package com.dream.universe.space.command.application.controller;
//
//import com.dream.universe.space.command.application.service.AwsS3Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//public class S3Controller {
//
//    static private AwsS3Service awsS3Service;
//
//    public S3Controller(AwsS3Service awsS3Service){
//        this.awsS3Service = awsS3Service;
//    }
//
//    @PostMapping("/maps/insert")
//    public String uploadFile(
//            @RequestParam("category") String category,
//            @RequestPart(value = "file") MultipartFile multipartFile) {
//        return awsS3Service.uploadFileV1(category, multipartFile);
//    }
//}
