package com.sf.learning.hibernate.dao.impl;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sf.learning.hibernate.dao.CompanyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-config/module/applicationContext.xml",
	"/spring-config/persistence/applicationContext-persistence-common.xml"})
@TransactionConfiguration(transactionManager="jdbcTransactionManager", defaultRollback=true)
@Transactional
public class CompanyJdbcDAOImplTest extends AbstractCompandyDAOImplTest {

	@Autowired
	private CompanyJdbcDAOImpl companyDAO;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected CompanyDAO initDAO() {
		return this.companyDAO;
	}

}
