package com.gachon.data_analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gachon.data_analysis.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
