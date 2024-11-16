package com.gachon.data_analysis.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockInfo {

    private Long id;

    private String ticker; // 종목 코드

    private String name; // 종목명

    private double recommendationScore; // 추천 퍼센티지

    private int upVotes; // 찬성 투표 수

    private int downVotes; // 반대 투표 수

    private int currentPrice; //현재가

    private int previousClose; //전일 종가

    private int priceChange; //등락

    private int changePercentage; // 등락 비율
}
