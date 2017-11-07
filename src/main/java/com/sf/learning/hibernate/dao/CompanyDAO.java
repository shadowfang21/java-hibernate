package com.sf.learning.hibernate.dao;

import java.util.List;

import com.sf.learning.hibernate.model.Company;

public interface CompanyDAO {
	
	List<Company> listAll();
	
	Company getById(long id);
	
	void deleteById(long id);
	
	Company update(Company company);
	
	Company create(Company company);
	
	List<Company> findByAddress(String address);
}
