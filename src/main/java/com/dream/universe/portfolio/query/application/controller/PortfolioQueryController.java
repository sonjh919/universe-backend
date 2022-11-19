package com.dream.universe.portfolio.query.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.portfolio.query.application.service.PortfolioQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolios")
public class PortfolioQueryController {

    private final PortfolioQueryService portfolioQueryService;

    public PortfolioQueryController(PortfolioQueryService portfolioQueryService){this.portfolioQueryService = portfolioQueryService;}

    @GetMapping("")
    public ResponseEntity<ResponseDTO> findPortfolioById(@RequestHeader(value="Authorization")  String accessToken){
        System.out.println("포트폴리오 정보 조회 API");
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "포트폴리오 정보 조회 성공", portfolioQueryService.findPortfolioById(accessToken)));
    }
}
