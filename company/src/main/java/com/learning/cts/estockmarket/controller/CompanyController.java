package com.learning.cts.estockmarket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.cts.estockmarket.exception.CompanyException;
import com.learning.cts.estockmarket.model.Company;
import com.learning.cts.estockmarket.service.CompanyService;

@RestController
@RequestMapping("/api/v1.0/market/company")
@CrossOrigin("*")
public class CompanyController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	CompanyService companyService;

	@PostMapping("/register")
	public ResponseEntity<String> registerCompany(@RequestBody Company company) {

		String companyCode = company.getCompanyCode();

		try {
			long companyCodeCount = companyService.companyCodeExist(companyCode);

			if (companyCodeCount != 0) {
				return new ResponseEntity<>("Company code already exist", HttpStatus.OK);
			}
			companyService.registerCompany(company);
		} catch (CompanyException e) {
			logger.error("Class CompanyController : Failed to register company");
		}

		return new ResponseEntity<>("Company registered successfully", HttpStatus.CREATED);
	}

	@GetMapping("/info/{companyCode}")
	public ResponseEntity<Company> fetchCompanyDetailsByCompanyCode(@PathVariable("companyCode") String companyCode) {
		Company company = null;
		try {
			company = companyService.fetchCompanyDetailsByCompanyCode(companyCode);
		} catch (CompanyException e) {
			logger.error("Class CompanyController : Failed to fetch company details");
		}
		return new ResponseEntity<>(company, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Company>> fetchAllCompanyDetails() {
		List<Company> companyList = null;
		try {
			companyList = companyService.fetchAllCompanyDetails();
		} catch (CompanyException e) {
			logger.error("Class CompanyController : Failed to fetch all company details");
		}
		return new ResponseEntity<>(companyList, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{companyCode}")
	public ResponseEntity<List<Company>> deleteCompanyByCompanyCode(@PathVariable("companyCode") String companyCode) {
		List<Company> companyList = null;
		try {
			companyService.deleteCompanyByCompanyCode(companyCode);
			companyList = companyService.fetchAllCompanyDetails();
			return new ResponseEntity<>(companyList, HttpStatus.OK);
		} catch (CompanyException e) {
			logger.error("Class CompanyController : Failed to delete company");
		}
		return new ResponseEntity<>(companyList, HttpStatus.OK);
	}

}
