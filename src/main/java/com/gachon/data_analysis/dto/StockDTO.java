package com.gachon.data_analysis.dto;

import java.math.BigDecimal;

import com.gachon.data_analysis.domain.StockInfo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockDTO {
    private Long id;
    private String ticker;
    private String name;
    private double recommendationScore;
    private int upVotes;
    private int downVotes;
    private int currentPrice; //현재가
    private int previousClose; //전일 종가
    private String priceChange; //등락폭(원)
    private String changePercentage; // 등락 비율

    public static StockDTO fromDomain(StockInfo stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .ticker(stock.getTicker())
                .name(stock.getName())
                .recommendationScore(stock.getRecommendationScore())
                .upVotes(stock.getUpVotes())
                .downVotes(stock.getDownVotes())
                .currentPrice(stock.getCurrentPrice())
                .previousClose(stock.getPreviousClose())
                .priceChange(stock.getPriceChange())
                .changePercentage(stock.getChangePercentage())
                .build();
    }
}