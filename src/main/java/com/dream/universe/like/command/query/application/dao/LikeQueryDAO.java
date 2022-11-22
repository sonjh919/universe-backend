package com.dream.universe.like.command.query.application.dao;

import com.dream.universe.like.command.domain.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeQueryDAO extends JpaRepository<Like, Long> {
    List<Like> findAllByMemberCode(Long memberCode);
}
