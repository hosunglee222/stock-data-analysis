package com.gachon.data_analysis.entity;

import jakarta.persistence.*;
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
}