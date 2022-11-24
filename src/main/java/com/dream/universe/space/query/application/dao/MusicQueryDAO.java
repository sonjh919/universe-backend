package com.dream.universe.space.query.application.dao;

import com.dream.universe.space.domain.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicQueryDAO extends JpaRepository<Music, Long> {
}
