package com.gachon.data_analysis.dto;

import java.math.BigDecimal;

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
}