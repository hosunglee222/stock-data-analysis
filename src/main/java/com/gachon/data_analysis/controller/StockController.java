package com.gachon.data_analysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gachon.data_analysis.dto.RecommendStockDTO;
import com.gachon.data_analysis.entity.Stock;
import com.gachon.data_analysis.service.StockService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/top10")
    public List<RecommendStockDTO> getTop10Stocks(){
        List<Stock> stocks = stockService.getTop10Stocks();

        return stocks.stream()
                .map(RecommendStockDTO::fromEntity)
                .toList();
    }
}
