package com.dream.universe.space.command.application.dao;


import com.dream.universe.space.domain.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDAO  extends JpaRepository<Music, Long> {
}
