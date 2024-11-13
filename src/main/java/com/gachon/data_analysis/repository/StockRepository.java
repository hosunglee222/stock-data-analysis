package com.gachon.data_analysis.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gachon.data_analysis.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s ORDER BY s.recommendationScore DESC")
    List<Stock> findTop10Stocks(Pageable pageable);

    Optional<Stock> findByName(String stockName);
}
