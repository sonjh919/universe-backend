package com.dream.universe.portfolio.query.application.dao;

import com.dream.universe.portfolio.domain.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioQueryDAO extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findAllByMemberCode(Long memberCode);

}
