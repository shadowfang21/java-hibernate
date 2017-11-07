package com.sf.learning.toolman.dao;

import java.util.List;

import com.sf.learning.toolman.model.Customer;

public interface CustomerDAO {
	
	List<Customer> listAll();
	
	Customer load(long id);
	
}
