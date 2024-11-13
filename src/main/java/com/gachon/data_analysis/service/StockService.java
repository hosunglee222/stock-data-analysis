package com.gachon.data_analysis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gachon.data_analysis.entity.Stock;
import com.gachon.data_analysis.repository.StockRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<Stock> getTop10Stocks(){
        return stockRepository.findTop10Stocks();
    }
}
