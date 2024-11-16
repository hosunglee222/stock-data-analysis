package com.gachon.data_analysis.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

import com.gachon.data_analysis.domain.StockInfo;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker; // 종목 코드

    private String name; // 종목명

    private double recommendationScore; // 추천 퍼센티지

    private int upVotes; // 찬성 투표 수

    private int downVotes; // 반대 투표 수

    private int currentPrice; //현재가

    private int previousClose; //전일 종가

    private int priceChange; //등락

    private String changePercentage; // 등락 비율


    public StockInfo toStockInfo(BigDecimal price) {
        return StockInfo.builder()
                .id(this.id)
                .ticker(this.ticker)
                .name(this.name)
                .recommendationScore(this.recommendationScore)
                .upVotes(this.upVotes)
                .downVotes(this.downVotes)
                .currentPrice(this.currentPrice)
                .priceChange(this.priceChange)
                .changePercentage(this.changePercentage)
                .build();
    }

    public void voteStock(boolean isRecommend){
        if (isRecommend) upVotes++;
        else downVotes++;
    }
}