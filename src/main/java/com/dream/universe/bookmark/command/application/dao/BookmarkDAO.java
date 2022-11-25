package com.dream.universe.bookmark.command.application.dao;

import com.dream.universe.bookmark.domain.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookmarkDAO extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findAllBySpaceCode(long spaceCode);
}
