package com.gachon.data_analysis.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gachon.data_analysis.domain.StockInfo;
import com.gachon.data_analysis.entity.Stock;
import com.gachon.data_analysis.repository.StockRepository;

import yahoofinance.YahooFinance;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<Stock> getTop10Stocks(){
        Pageable pageable = PageRequest.of(0, 10);  // 첫 페이지에서 10개 항목 가져오기
        return stockRepository.findTop10Stocks(pageable);
    }

    public StockInfo searchStockInfo(String stockName) {
        Stock stock = stockRepository.findByName(stockName)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));

        BigDecimal stockPrice;
        try {
            stockPrice = YahooFinance.get(stock.getTicker()).getQuote().getPrice();
        } catch (Exception e) {
            stockPrice = BigDecimal.ZERO;
            System.err.println("Failed to retrieve stock price: " + e.getMessage());
        }

        return stock.toStockInfo(stockPrice);
    }

    @Transactional
    public void voteStock(Long stockId, boolean isRecommend) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));
        stock.voteStock(isRecommend);
    }
}
