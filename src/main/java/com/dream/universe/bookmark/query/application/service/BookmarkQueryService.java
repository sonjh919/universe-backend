package com.dream.universe.bookmark.query.application.service;


import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.bookmark.query.application.dao.BookmarkQueryDAO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookmarkQueryService {
    public final BookmarkQueryDAO bookmarkQueryDAO;
    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public BookmarkQueryService(BookmarkQueryDAO bookmarkQueryDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.bookmarkQueryDAO = bookmarkQueryDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public List<Bookmark> findAllById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Bookmark> bookmark = bookmarkQueryDAO.findAllByMemberCode(member.getMemberCode());

        return bookmark;
    }
}
