package com.sf.learning.hibernate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sf.learning.hibernate.dao.CompanyDAO;
import com.sf.learning.hibernate.model.Company;
import com.sf.learning.hibernate.rowmapper.CompanyRowMapper;

@Repository
public class CompanyJdbcDAOImpl implements CompanyDAO {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Company> listAll() {
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from company");
		
		return null;
	}

	@Override
	public Company getById(long id) {
		return null;
	}

	@Override
	public void deleteById(long id) {
		
	}

	@Override
	public Company update(Company company) {
		
		return company;
	}

	@Override
	public Company create(final Company company) {
		return null;
	}

	@Override
	public List<Company> findByAddress(final String address) {
		return null;
	}

}
