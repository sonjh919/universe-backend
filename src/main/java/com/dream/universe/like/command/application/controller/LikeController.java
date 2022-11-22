package com.dream.universe.like.command.application.controller;

import com.dream.universe.like.command.application.dto.LikeDTO;
import com.dream.universe.like.command.application.service.LikeService;
import com.dream.universe.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;
    public LikeController(LikeService likeService){this.likeService = likeService;}

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insert(@RequestHeader(value="Authorization")  String accessToken, @RequestBody LikeDTO likeDTO){
        System.out.println("좋아요 추가 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "즐겨찾기 추가 성공", likeService.insert(accessToken, likeDTO)));
    }

    @DeleteMapping("/delete/{likeCode}")
    public ResponseEntity<ResponseDTO> deleteLike(@PathVariable Long likeCode){
        System.out.println("좋아요 삭제 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "즐겨찾기 삭제 성공", likeService.delete(likeCode)));
    }
}
