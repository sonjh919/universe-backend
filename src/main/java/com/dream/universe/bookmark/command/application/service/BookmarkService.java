package com.dream.universe.bookmark.command.application.service;

import com.dream.universe.bookmark.command.application.dto.BookmarkDTO;
import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.bookmark.command.application.dao.BookmarkDAO;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    public final BookmarkDAO bookmarkDAO;

    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public BookmarkService(BookmarkDAO bookmarkDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.bookmarkDAO = bookmarkDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public long insert(String accessToken, BookmarkDTO bookmarkDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Bookmark bookmark = new Bookmark();
        bookmark.setMemberCode(memberDTO.getMemberCode());
        bookmark.setSpaceCode(bookmarkDTO.getSpaceCode());

        bookmarkDAO.save(bookmark);

        return bookmark.getBookmarkCode();
    }


    public Long delete(Long bookmarkCode) {
        bookmarkDAO.deleteById(bookmarkCode);
        return bookmarkCode;
    }
}
