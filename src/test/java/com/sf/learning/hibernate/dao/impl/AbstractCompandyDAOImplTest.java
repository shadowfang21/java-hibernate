package com.sf.learning.hibernate.dao.impl;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

import com.sf.learning.hibernate.dao.CompanyDAO;
import com.sf.learning.hibernate.model.Company;

public abstract class AbstractCompandyDAOImplTest {

	private CompanyDAO companyDAO;
	
	protected abstract CompanyDAO initDAO();
	
	private Company expected;
	
	@Before
	public void setUp() throws Exception {
		this.companyDAO = initDAO();
		
		expected = new Company();
		expected.setId(1);
		expected.setAddress("address");
		expected.setName("BT");
	}

	@Test
	public void testListAll() {
		final List<Company> result = companyDAO.listAll();
		assertEquals(3, result.size());
		assertThat(expected, samePropertyValuesAs(result.get(0)));
	}

	@Test
	public void testGetById() {
		final Company result = companyDAO.getById(1);
		assertThat(expected, samePropertyValuesAs(result));
	}

	@Test
	public void testCreate() {
		final Company newCompany = new Company();
		newCompany.setAddress("new address");
		newCompany.setName("new name");
		companyDAO.create(newCompany);

		final Company result = companyDAO.getById(4);
		
		assertNotEquals(newCompany, result);
		assertThat(newCompany, samePropertyValuesAs(result));
	}

	@Test
	public void testFindByAddress() {
		List<Company> result = companyDAO.findByAddress("address2");
		assertEquals(2, result.size());
	}
	
	@Test
	public void testDeleteById() {
		companyDAO.deleteById(1);
		assertEquals(2, companyDAO.listAll().size());
	}

	@Test
	public void testUpdate() {
		final Company company = companyDAO.getById(3);
		company.setName("whatevernameis");
		companyDAO.update(company);
		final Company result = companyDAO.getById(3);
		
		assertNotEquals(company, result);
		assertThat(company, samePropertyValuesAs(result));
	}
}
