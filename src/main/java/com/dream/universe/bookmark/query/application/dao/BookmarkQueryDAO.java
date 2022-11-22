package com.dream.universe.bookmark.query.application.dao;

import com.dream.universe.bookmark.domain.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkQueryDAO  extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findAllByMemberCode(Long memberCode);
}
