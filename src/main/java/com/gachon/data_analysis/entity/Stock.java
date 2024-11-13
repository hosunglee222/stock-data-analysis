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
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ticker; // 종목 코드

    private String name; // 종목명

    private double recommendationScore; // 추천 퍼센티지

    private int upVotes; // 찬성 투표 수

    private int downVotes; // 반대 투표 수

    public StockInfo toStockInfo(BigDecimal price) {
        return StockInfo.builder()
                .id(this.id)
                .ticker(this.ticker)
                .name(this.name)
                .price(price)
                .recommendationScore(this.recommendationScore)
                .upVotes(this.upVotes)
                .downVotes(this.downVotes)
                .build();
    }

    public void voteStock(boolean isRecommend){
        if (isRecommend) upVotes++;
        else downVotes++;
    }
}