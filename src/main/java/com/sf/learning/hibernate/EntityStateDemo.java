package com.sf.learning.hibernate;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.sf.learning.hibernate.model.Company;

@Component
@ImportResource({"classpath:spring-config/module/applicationContext.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-common.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-manager.xml"})
public class EntityStateDemo {
	
	//don't ever do this in real world
	@Autowired
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) throws BeansException, Exception {
		final ConfigurableApplicationContext context = 
				new SpringApplicationBuilder(EntityStateDemo.class)
					.headless(false)
					.run(args);
		
		context.getBean(EntityStateDemo.class).execute();
	}

	public void execute() {
		final Session session = sessionFactory.openSession();
		session.setFlushMode(FlushMode.MANUAL);
		final Company company = new Company();
		company.setName("transient");
		try {
			session.save(company);
			company.setName("managed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		company.setName("detached");
	}
}
