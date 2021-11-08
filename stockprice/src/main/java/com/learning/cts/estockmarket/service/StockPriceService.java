package com.learning.cts.estockmarket.service;

import java.util.Date;

import com.learning.cts.estockmarket.exception.StockPriceException;
import com.learning.cts.estockmarket.model.StockPrice;
import com.learning.cts.estockmarket.model.StockPriceDTO;

public interface StockPriceService {

	void addStockPrice(StockPrice stockPrice) throws StockPriceException;

	StockPriceDTO fetchStockPriceList(String companyCode, Date startDate, Date endDate) throws StockPriceException;

}
