package com.gachon.data_analysis.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecommendStockDTO {

    private String ticker;
    private String name;
    private Double recommendScore;
}
