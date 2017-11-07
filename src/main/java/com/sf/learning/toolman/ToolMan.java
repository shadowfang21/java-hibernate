package com.sf.learning.toolman;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.sf.learning.toolman.dao.CustomerDAO;
import com.sf.learning.toolman.dao.MasterDAO;
import com.sf.learning.toolman.dao.OrderDAO;
import com.sf.learning.toolman.model.Customer;
import com.sf.learning.toolman.model.Master;
import com.sf.learning.toolman.model.Order;

@Component
@ImportResource({"classpath:spring-config/module/applicationContext.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-common.xml",
		"classpath:spring-config/persistence/applicationContext-persistence-manager.xml"})
public class ToolMan {
	
	@Autowired
	private Customer customer;
	
	public String showCustomer() {
		return this.toString() + "toolMan customer is : \n" + customer.toString();
	}
	
	public static void main(String[] args) throws BeansException, Exception {
		final ConfigurableApplicationContext context = 
				new SpringApplicationBuilder(ToolMan.class)
					.headless(false)
					.run(args);
		
		context.getBean(ToolMan.class).execute();
	}

	
	@Autowired
	//@Qualifier("jdbcCustomerDAOImpl")
	@Qualifier("hibernateCustomerDAOImpl")
	private CustomerDAO customerDAO;
	
	private MasterDAO masterDAO;
	
	private OrderDAO orderDAO;
	
	public void execute() {
		
		System.out.println("user 1 login");
		
		long userId = 1;
		
		Customer user = customerDAO.load(userId);
		
		//userId, customerI, id
		System.out.println("user name : " + user.getName());
		
		//enter master page
		List<Master> masterList = masterDAO.listAll(); 
		
		//create order
		
		final int masterPickedIndex = 0;
		
		final Order order = new Order();
		order.setCustomerId(userId);
		order.setMasterid(masterList.get(masterPickedIndex).getMasterId());
		order.setLocation("location");
		
		orderDAO.save(order);
	}
}
