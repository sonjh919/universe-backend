package com.dream.universe.space.command.application.service;


import com.dream.universe.bookmark.command.application.dao.BookmarkDAO;
import com.dream.universe.bookmark.domain.model.Bookmark;
import com.dream.universe.jwt.TokenProvider;
import com.dream.universe.member.dao.MemberMapper;
import com.dream.universe.member.dto.MemberDTO;
import com.dream.universe.space.command.application.dao.MusicDAO;
import com.dream.universe.space.command.application.dao.SpaceDAO;
import com.dream.universe.space.command.application.dto.MusicDTO;
import com.dream.universe.space.command.application.dto.SpaceDTO;
import com.dream.universe.space.domain.model.Music;
import com.dream.universe.space.domain.model.Space;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {

    public final SpaceDAO spaceDAO;
    public final MusicDAO musicDAO;
    public final BookmarkDAO bookmarkDAO;

    private final MemberMapper memberMapper;
    public final TokenProvider tokenProvider;

    public SpaceService(SpaceDAO spaceDAO,MusicDAO musicDAO, BookmarkDAO bookmarkDAO, MemberMapper memberMapper, TokenProvider tokenProvider){
        this.spaceDAO = spaceDAO;
        this.musicDAO = musicDAO;
        this.bookmarkDAO = bookmarkDAO;
        this.memberMapper = memberMapper;
        this.tokenProvider = tokenProvider;
    }

    public Space mapInsert(String accessToken, SpaceDTO spaceDTO) {
        String memberId = tokenProvider.getUserId(accessToken);
        MemberDTO memberDTO = memberMapper.findById(memberId);

        Space space = new Space();
        space.setMemberCode(memberDTO.getMemberCode());
        space.setSpaceMapinfo(spaceDTO.getSpaceMapinfo());
        space.setSpaceName("temp");
        space.setSpaceIntro("temp");
        space.setSpaceType("temp");
        space.setSpaceThumbnail("temp");
        space.setSpaceLike(0);
        space.setSpaceBookmark(0);
        space.setSpaceReport(0);
        space.setSpaceWarning(0);

        spaceDAO.save(space);

        Optional<Space> oSpace = spaceDAO.findById(space.getSpaceCode());

        Space space2 = oSpace.get();

        Music music = new Music();
        music.setSpaceCode(space2.getSpaceCode());

        musicDAO.save(music);

        return space;
    }
    public String mapUpdate(SpaceDTO spaceDTO) {
        Optional<Space> oSpace = spaceDAO.findById(spaceDTO.getSpaceCode());

        Space space = oSpace.get();
        space.setSpaceMapinfo(spaceDTO.getSpaceMapinfo());

        spaceDAO.save(space);

        return space.getSpaceMapinfo();
    }

    public long spaceInsert(SpaceDTO spaceDTO) {

        Optional<Space> oSpace = spaceDAO.findById(spaceDTO.getSpaceCode());

        Space space = oSpace.get();
        space.setSpaceName(spaceDTO.getSpaceName());
        space.setSpaceIntro(spaceDTO.getSpaceIntro());
        space.setSpaceType(spaceDTO.getSpaceType());
        space.setSpacePassword(spaceDTO.getSpacePassword());
        space.setSpaceTag1(spaceDTO.getSpaceTag1());
        space.setSpaceTag2(spaceDTO.getSpaceTag2());
        space.setSpaceTag3(spaceDTO.getSpaceTag3());

        spaceDAO.save(space);

        return space.getSpaceCode();

    }

    public String thumbnailInsert(SpaceDTO spaceDTO) {
        Optional<Space> oSpace = spaceDAO.findById(spaceDTO.getSpaceCode());

        Space space = oSpace.get();
        space.setSpaceThumbnail(spaceDTO.getSpaceThumbnail());

        spaceDAO.save(space);

        return space.getSpaceThumbnail();
    }


    public Long delete(long spaceCode) {
        spaceDAO.deleteById(spaceCode);
        musicDAO.deleteById(spaceCode);

        List<Bookmark> Bookmark = bookmarkDAO.findAllBySpaceCode(spaceCode);

        for(int i=Bookmark.size()-1;i>=0;i--) {
            Bookmark bookmark = Bookmark.get(i);
            bookmarkDAO.deleteById(bookmark.getBookmarkCode());
        }
        return spaceCode;
    }

    public long likeUpdate(SpaceDTO spaceDTO) {
        Optional<Space> oSpace = spaceDAO.findById(spaceDTO.getSpaceCode());

        Space space = oSpace.get();
        space.setSpaceLike(space.getSpaceLike()+spaceDTO.getSpaceLike());

        spaceDAO.save(space);

        return space.getSpaceLike();
    }

    public String musicInsert(MusicDTO musicDTO) {
        Optional<Music> oMusic = musicDAO.findById(musicDTO.getSpaceCode());

        Music music = oMusic.get();
        music.setMusicUrl(musicDTO.getMusicUrl());

        musicDAO.save(music);

        return music.getMusicUrl();
    }
}
