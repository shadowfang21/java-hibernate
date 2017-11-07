package com.sf.learning.hibernate;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.sf.learning.hibernate.dao.CompanyDAO;
import com.sf.learning.hibernate.model.Company;

@Component
@ImportResource({"classpath:spring-config/module/applicationContext.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-common.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-manager.xml"})
public class BaseCRUDLab {
	
	@Autowired
//	@Qualifier("companyHibernateDAOImpl")
	@Qualifier("companyJdbcDAOImpl")
	private CompanyDAO companyDAO;
	
	
	
	public static void main(String[] args) throws BeansException, Exception {
		final ConfigurableApplicationContext context = 
				new SpringApplicationBuilder(BaseCRUDLab.class)
					.headless(false)
					.run(args);
		
//		context.getBean(BaseCRUDLab.class).execute();
	}

	public void execute() {
		
//		System.out.println("----insert new record");
//		final Company newCompany = new Company();
//		newCompany.setAddress("newAddress");
//		newCompany.setName("newName");
//		companyDAO.create(newCompany);
//		
//		System.out.println(companyDAO.listAll());
		
//		System.out.println("----find by id");
//		final Company bt = companyDAO.getById(1);
//		System.out.println(bt);
//		
//		bt.setAddress("newAddress");
//		
//		System.out.println("----update single row");
//		companyDAO.update(bt);
//		
//		System.out.println("----delete by id");
//		companyDAO.deleteById(2);
//		
//		System.out.println(companyDAO.listAll());
//		
//		System.out.println("----find by address : newAddress");
//		System.out.println(companyDAO.findByAddress("newAddress"));
		
	}
}
