package com.gachon.data_analysis.dto;

import com.gachon.data_analysis.entity.Stock;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecommendStockDTO {

    private String ticker;
    private String name;
    private Double recommendScore;
    private int currentPrice; //현재가
    private String changePercentage; // 등락 비율

    public static RecommendStockDTO fromEntity(Stock stock) {
        return RecommendStockDTO.builder()
                .ticker(stock.getTicker())
                .name(stock.getName())
                .recommendScore(stock.getRecommendationScore())
                .currentPrice(stock.getCurrentPrice())
                .changePercentage(stock.getChangePercentage())
                .build();
    }
}
