package com.learning.cts.estockmarket.service.impl;

import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.learning.cts.estockmarket.exception.StockPriceException;
import com.learning.cts.estockmarket.model.StockPrice;
import com.learning.cts.estockmarket.model.StockPriceDTO;
import com.learning.cts.estockmarket.repository.StockPriceRepository;
import com.learning.cts.estockmarket.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	
	@Autowired
	StockPriceRepository stockPriceRepository;

	@Override
	public void addStockPrice(StockPrice stockPrice) throws StockPriceException{
		stockPrice.setStockDate(new Date());
		stockPriceRepository.save(stockPrice);
	}

	@Override
	public StockPriceDTO fetchStockPriceList(String companyCode, Date startDate, Date endDate) throws StockPriceException{
		List<StockPrice> stockPriceList = stockPriceRepository.fetchStockPrice(companyCode, startDate, endDate);
		StockPriceDTO stockPriceDTO = new StockPriceDTO();
		if(!CollectionUtils.isEmpty(stockPriceList)) {
			DoubleSummaryStatistics stats = stockPriceList.stream()
	                .mapToDouble((x) -> x.getStockPriceValue())
	                .summaryStatistics();
			stockPriceDTO.setAverage(stats.getAverage());
			stockPriceDTO.setMin(stats.getMin());
			stockPriceDTO.setMax(stats.getMax());
		}
		stockPriceDTO.setStockPriceList(stockPriceList);
		return stockPriceDTO;
	}

}
