package com.gachon.data_analysis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gachon.data_analysis.common.response.ResponseDto;
import com.gachon.data_analysis.domain.StockInfo;
import com.gachon.data_analysis.dto.RecommendStockDTO;
import com.gachon.data_analysis.dto.StockDTO;
import com.gachon.data_analysis.entity.Stock;
import com.gachon.data_analysis.service.StockService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/top10")
    public ResponseDto<List<RecommendStockDTO>> getTop10Stocks(){
        List<Stock> stocks = stockService.getTop10Stocks();

        return ResponseDto.onSuccess(stocks.stream()
                .map(RecommendStockDTO::fromEntity)
                .toList());
    }

    @GetMapping("/search/{stockName}")
    public ResponseDto<StockDTO> searchStock(@PathVariable String stockName){
        StockInfo stock = stockService.searchStockInfo(stockName);
        return ResponseDto.onSuccess(StockDTO.fromDomain(stock));
    }

    @PostMapping("/{stockId}/vote")
    public ResponseDto<String> voteStock(@PathVariable Long stockId, @RequestParam boolean isRecommend){

        String message = isRecommend ? "추천 완료했습니다." : "추천 취소했습니다.";
        return ResponseDto.onSuccess(message);
    }
}
