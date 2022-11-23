package com.dream.universe.bookmark.query.application.service;


import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.bookmark.query.application.dao.BookmarkQueryDAO;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.portfolio.domain.model.Portfolio;
import com.dream.universe.space.command.application.dao.SpaceDAO;
import com.dream.universe.space.domain.model.Space;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BookmarkQueryService {
    public final BookmarkQueryDAO bookmarkQueryDAO;

    public final SpaceDAO spaceDAO;
    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public BookmarkQueryService(BookmarkQueryDAO bookmarkQueryDAO, SpaceDAO spaceDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.bookmarkQueryDAO = bookmarkQueryDAO;
        this.spaceDAO = spaceDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public List<Bookmark> findAllById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Bookmark> bookmark = bookmarkQueryDAO.findAllByMemberCode(member.getMemberCode());

        return bookmark;
    }

    public List<Space> findAllSpaceInfoById(String accessToken) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO member = memberMapper.findById(memberId);

        List<Bookmark> bookmark = bookmarkQueryDAO.findAllByMemberCode(member.getMemberCode());

        List<Space> space = new ArrayList<Space>();

        for(int i=0;i<bookmark.size();i++){
            Optional<Space> oSpace =spaceDAO.findById(bookmark.get(i).getSpaceCode());
            Space tempSpace = oSpace.get();
            space.add(tempSpace);
            System.out.println("space = " + spaceDAO.findById(bookmark.get(i).getSpaceCode()));
        }

        return space;
    }
}
