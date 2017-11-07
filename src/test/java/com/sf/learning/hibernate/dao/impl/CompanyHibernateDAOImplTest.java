package com.sf.learning.hibernate.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sf.learning.hibernate.dao.CompanyDAO;
import com.sf.learning.hibernate.model.Company;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config/module/applicationContext.xml",
	"/spring-config/persistence/applicationContext-persistence-common.xml"})
@TransactionConfiguration(transactionManager="hibernateTransactionManager", defaultRollback=true)
@Transactional
public class CompanyHibernateDAOImplTest extends AbstractCompandyDAOImplTest {

	@Autowired
	private CompanyHibernateDAOImpl companyDAO;
	
	private String address;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		address = "address2";
	}

	@Test
	public void testQueryByCriteria() {
		List<Company> result = companyDAO.queryByCriteria(address);
		
		assertEquals(2, result.size());
	}

	@Test
	public void testQueryBySql() {
		List<Company> result = companyDAO.queryBySql(address);
		
		assertEquals(2, result.size());
	}

	@Test
	public void testQueryByHql() {
		List<Company> result = companyDAO.queryByHql(address);
		
		assertEquals(2, result.size());
	}

	@Override
	protected CompanyDAO initDAO() {
		return this.companyDAO;
	}

}
