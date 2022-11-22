package com.dream.universe.bookmark.command.application.service;

import com.dream.universe.bookmark.command.application.dto.BookmarkDTO;
import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.bookmark.command.application.dao.BookmarkDAO;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.command.application.dao.SpaceDAO;
import com.dream.universe.space.domain.model.Space;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookmarkService {
    public final BookmarkDAO bookmarkDAO;
    public final SpaceDAO spaceDAO;

    private final MemberMapper memberMapper;

    public final TokenProvider tokenProvider;

    public BookmarkService(BookmarkDAO bookmarkDAO, SpaceDAO spaceDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.bookmarkDAO = bookmarkDAO;
        this.spaceDAO = spaceDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public long insert(String accessToken, BookmarkDTO bookmarkDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Bookmark bookmark = new Bookmark();
        bookmark.setMemberCode(memberDTO.getMemberCode());
        bookmark.setSpaceCode(bookmarkDTO.getSpaceCode());


        Optional<Space> oSpace = spaceDAO.findById(bookmarkDTO.getSpaceCode());
        Space space = oSpace.get();
        space.setSpaceBookmark(space.getSpaceBookmark()+1);

        bookmarkDAO.save(bookmark);
        spaceDAO.save(space);

        return bookmark.getBookmarkCode();
    }


    public Long delete(Long bookmarkCode) {
        Optional<Bookmark> oBookmark = bookmarkDAO.findById(bookmarkCode);
        Bookmark bookmark = oBookmark.get();

        Optional<Space> oSpace = spaceDAO.findById(bookmark.getSpaceCode());
        Space space = oSpace.get();
        space.setSpaceBookmark(space.getSpaceBookmark()-1);

        bookmarkDAO.deleteById(bookmarkCode);
        spaceDAO.save(space);
        return bookmarkCode;
    }
}
