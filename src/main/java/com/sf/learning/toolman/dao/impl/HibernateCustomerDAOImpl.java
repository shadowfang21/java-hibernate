package com.sf.learning.toolman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sf.learning.toolman.dao.CustomerDAO;
import com.sf.learning.toolman.model.Customer;

@Repository("hibernateCustomerDAOImpl")
public class HibernateCustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer load(long id) {

		return (Customer) sessionFactory.openSession().load(Customer.class, id);
	}

}
