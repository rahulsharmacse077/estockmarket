package com.learning.cts.estockmarket.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.cts.estockmarket.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{
	
	@Query("SELECT c FROM Company c WHERE c.companyCode = ?1")
	Company fetchByCompanyCode(String companyCode);

	@Transactional
	@Modifying
	@Query("DELETE FROM Company c WHERE c.companyCode = ?1")
	void deleteByCompanyCode(String companyCode);
	
	@Query("select count(c) from Company c where c.companyCode = ?1")
	long countByCompanyCode(String code);

}
