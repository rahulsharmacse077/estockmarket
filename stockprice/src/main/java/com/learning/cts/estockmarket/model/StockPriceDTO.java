package com.learning.cts.estockmarket.model;

import java.util.List;

public class StockPriceDTO {

	private List<StockPrice> stockPriceList;
	private double min;
	private double max;
	private double average;

	public List<StockPrice> getStockPriceList() {
		return stockPriceList;
	}

	public void setStockPriceList(List<StockPrice> stockPriceList) {
		this.stockPriceList = stockPriceList;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

}
