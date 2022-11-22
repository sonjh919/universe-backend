package com.dream.universe.bookmark.query.application.controller;


import com.dream.universe.bookmark.query.application.service.BookmarkQueryService;
import com.dream.universe.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkQueryController {

    private final BookmarkQueryService bookmarkQueryService;
    public BookmarkQueryController(BookmarkQueryService bookmarkQueryService){this.bookmarkQueryService = bookmarkQueryService;}

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findBookmarkById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println("즐겨찾기 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "즐겨찾기 정보 조회 성공",  bookmarkQueryService.findAllById(accessToken)));

    }
}
