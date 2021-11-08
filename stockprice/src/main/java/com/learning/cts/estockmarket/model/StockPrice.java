package com.learning.cts.estockmarket.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stockprice")
public class StockPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_price_id")
	private int stockPriceId;
	
	@Column(name = "company_code", nullable = false)
	private String companyCode;
	
	@Column(name = "stock_price", nullable = false)
	private double stockPriceValue;
	
	@Column(name = "stock_date") 
	private Date stockDate;

	public int getStockPriceId() {
		return stockPriceId;
	}

	public void setStockPriceId(int stockPriceId) {
		this.stockPriceId = stockPriceId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public double getStockPriceValue() {
		return stockPriceValue;
	}

	public void setStockPriceValue(double stockPriceValue) {
		this.stockPriceValue = stockPriceValue;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

}
