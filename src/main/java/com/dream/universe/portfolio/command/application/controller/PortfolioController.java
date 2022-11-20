package com.dream.universe.portfolio.command.application.controller;

import com.dream.universe.common.ResponseDTO;
import com.dream.universe.portfolio.command.application.dto.PortfolioDTO;
import com.dream.universe.portfolio.command.application.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService){this.portfolioService = portfolioService;}

    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> insert(@RequestHeader(value="Authorization")  String accessToken, @RequestBody PortfolioDTO portfolioDTO){
        System.out.println("포트폴리오 추가 API");
        System.out.println("portfolioDTO = " + portfolioDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "포트폴리오 추가 성공", portfolioService.insert(accessToken, portfolioDTO)));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestHeader(value="Authorization")  String accessToken, @RequestBody PortfolioDTO portfolioDTO){
        System.out.println("포트폴리오 수정 API");
        System.out.println("portfolioDTO = " + portfolioDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "포트폴리오 수정 성공", portfolioService.update(accessToken, portfolioDTO)));
    }
}
