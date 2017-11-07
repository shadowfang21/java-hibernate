package com.sf.learning.toolman.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sf.learning.toolman.dao.CustomerDAO;
import com.sf.learning.toolman.model.Customer;

@Repository("jdbcCustomerDAOImpl")
public class JDBCustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Customer> listAll() {
		return null;
	}

	@Override
	public Customer load(long id) {
		return jdbcTemplate.queryForObject("select customer_id, name, phone from t_customer where customer_id = ?",
				new Object[]{id}, new RowMapper<Customer>() {

					@Override
					public Customer mapRow(ResultSet arg0, int arg1) throws SQLException {
						final Customer customer = new Customer();
						customer.setCustomerId(arg0.getLong("customer_id"));
						customer.setName(arg0.getString("name"));
						customer.setPhone(arg0.getString("phone"));
						return customer;
					}
			
		});
	}

}
