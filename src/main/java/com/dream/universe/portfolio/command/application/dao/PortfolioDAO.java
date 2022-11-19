package com.dream.universe.portfolio.command.application.dao;

import com.dream.universe.portfolio.domain.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioDAO extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByMemberCodeAndPortfolioIndex(Long memberCode, Long portfolioIndex);
}
