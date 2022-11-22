package com.dream.universe.like.command.application.dao;


import com.dream.universe.like.command.domain.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDAO extends JpaRepository<Like, Long> {
}
