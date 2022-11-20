package com.dream.universe.photo.query.application.dao;

import com.dream.universe.photo.domain.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoQueryDAO  extends JpaRepository<Photo, Long> {
    List<Photo> findAllByMemberCode(Long memberCode);
}
