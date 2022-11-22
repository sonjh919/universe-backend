package com.dream.universe.bookmark.command.application.controller;

import com.dream.universe.bookmark.command.application.dto.BookmarkDTO;
import com.dream.universe.bookmark.command.application.service.BookmarkService;
import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.common.ResponseDTO;
import com.dream.universe.portfolio.command.application.dto.PortfolioDTO;
import com.dream.universe.portfolio.command.application.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
    private final BookmarkService bookmarkService;
    public BookmarkController(BookmarkService bookmarkService){this.bookmarkService = bookmarkService;}

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insert(@RequestHeader(value="Authorization")  String accessToken, @RequestBody BookmarkDTO bookmarkDTO){
        System.out.println("즐겨찾기 추가 API");

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "즐겨찾기 추가 성공", bookmarkService.insert(accessToken, bookmarkDTO)));
    }

    @DeleteMapping("/delete/{bookmarkCode}")
    public ResponseEntity<ResponseDTO> deleteBookmark(@PathVariable Long bookmarkCode){
        System.out.println("즐겨찾기 삭제 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "즐겨찾기 삭제 성공", bookmarkService.delete(bookmarkCode)));
    }
}
