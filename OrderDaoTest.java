package com.lti.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.GenericDao;
import com.lti.entity.Order;

public class OrderDaoTest {

	@Test
		
		public void placeOrder() {
		         GenericDao dao = new GenericDao();
		         Customer cust = (Customer) dao.fetchByPk(Customer.class,1);
		         
		         Order order = new Order();
		        // order.setId(1);
		         order.setOrderDate(new Date());
		         order.setAmount(653330);
		         order.setCustomer(cust);
		         dao.save(order);
		
	}
	
	@Test
	     public void display() {
		 GenericDao dao = new GenericDao();
		 List<Order> or = dao.fetchAll(Order.class);
		 for(Order order: or) {
			 System.out.println(order.getId());
			 System.out.println(order.getOrderDate());
			 System.out.println(order.getAmount());
			 System.out.println(order.getCustomer().getName());
		 }
	}
	

}
