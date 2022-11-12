package com.dream.universe.space.command.application.dao;

import com.dream.universe.space.domain.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceDAO extends JpaRepository<Space, Long> {
}
