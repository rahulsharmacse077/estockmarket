package com.learning.cts.estockmarket.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.cts.estockmarket.model.StockPrice;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, String>{

	@Query(value = "SELECT * FROM stockprice WHERE company_code = ?1 AND CAST(stock_date AS Date) BETWEEN ?2 AND ?3", nativeQuery = true)
	List<StockPrice> fetchStockPrice(String companyCode, Date startDate, Date endDate);

}
