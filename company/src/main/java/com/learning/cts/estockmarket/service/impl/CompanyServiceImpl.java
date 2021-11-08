package com.learning.cts.estockmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.cts.estockmarket.exception.CompanyException;
import com.learning.cts.estockmarket.model.Company;
import com.learning.cts.estockmarket.repository.CompanyRepository;
import com.learning.cts.estockmarket.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public void registerCompany(Company company) throws CompanyException {
		companyRepository.save(company);
	}

	@Override
	public Company fetchCompanyDetailsByCompanyCode(String companyCode) throws CompanyException {
		return companyRepository.fetchByCompanyCode(companyCode);
	}

	@Override
	public List<Company> fetchAllCompanyDetails() throws CompanyException {
		return companyRepository.findAll();
	}

	@Override
	public void deleteCompanyByCompanyCode(String companyCode) throws CompanyException {
		companyRepository.deleteByCompanyCode(companyCode);
	}

	@Override
	public long companyCodeExist(String companyCode) throws CompanyException {
		return companyRepository.countByCompanyCode(companyCode);
	}

}
