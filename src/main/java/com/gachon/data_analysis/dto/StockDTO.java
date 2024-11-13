package com.gachon.data_analysis.dto;

import java.math.BigDecimal;

import com.gachon.data_analysis.domain.StockInfo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockDTO {
    private String ticker;
    private String name;
    private BigDecimal price;
    private double recommendationScore;
    private int upVotes;
    private int downVotes;

    public static StockDTO fromDomain(StockInfo stock) {
        return StockDTO.builder()
                .ticker(stock.getTicker())
                .name(stock.getName())
                .price(stock.getPrice())
                .recommendationScore(stock.getRecommendationScore())
                .upVotes(stock.getUpVotes())
                .downVotes(stock.getDownVotes())
                .build();
    }
}