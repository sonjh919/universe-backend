package com.dream.universe.photo.command.application.dao;

import com.dream.universe.photo.domain.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDAO  extends JpaRepository<Photo, Long> {
}
