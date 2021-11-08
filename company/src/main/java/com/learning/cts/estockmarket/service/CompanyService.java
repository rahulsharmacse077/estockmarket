package com.learning.cts.estockmarket.service;

import java.util.List;

import com.learning.cts.estockmarket.exception.CompanyException;
import com.learning.cts.estockmarket.model.Company;

public interface CompanyService {

	void registerCompany(Company company) throws CompanyException;

	Company fetchCompanyDetailsByCompanyCode(String companyCode) throws CompanyException;

	List<Company> fetchAllCompanyDetails() throws CompanyException;

	void deleteCompanyByCompanyCode(String companyCode) throws CompanyException;

	long companyCodeExist(String companyCode) throws CompanyException;

}
