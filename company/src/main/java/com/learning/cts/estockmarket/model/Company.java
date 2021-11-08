package com.learning.cts.estockmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id") 
	private int companyId;

	@Column(name="company_code", nullable = false)
	private String companyCode;
	
	@Column(name="company_name", nullable = false)
	private String companyName;
	
	@Column(name="company_ceo", nullable = false)
	private String companyCeo;
	
	@Column(name="company_turnover", nullable = false)
	private double companyTurnover;
	
	@Column(name="company_website", nullable = false)
	private String companyWebsite;
	
	@Column(name="company_listed_in", nullable = false)
	private String companyListedIn;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCeo() {
		return companyCeo;
	}

	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}

	public double getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyListedIn() {
		return companyListedIn;
	}

	public void setCompanyListedIn(String companyListedIn) {
		this.companyListedIn = companyListedIn;
	}

}
