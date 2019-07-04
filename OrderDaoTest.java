package com.lti.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.GenericDao;
import com.lti.entity.Order;
import com.lti.entity.Payment;

public class OrderDaoTest {
	
	@Test
	public void placeOrder() {
		
		GenericDao dao=new GenericDao();
		Customer cust=(Customer)dao.fetchById(Customer.class,42);
		
		Order o=new Order();
		/*Date d;
		d = new SimpleDateFormat("dd/MM/yyyy").parse("27/10/1997");*/
		o.setOrderDate(new Date());
		o.setAmount(1788.50);
		o.setCustomer(cust);
		
		dao.save(o); 
		
		
	}
	
	@Test
	public void fetchOrderDetails() {
		
		GenericDao dao=new GenericDao();
		//Customer cust=(Customer)dao.fetchById(Customer.class,42);
		Payment payment=(Payment)dao.fetchById(Payment.class,84);
		Order order =(Order)dao.fetchById(Order.class, 61);
		/*Date d;
		d = new SimpleDateFormat("dd/MM/yyyy").parse("27/10/1997");*/
		order.setPayment(payment);
		dao.save(order);
		/*List<Order> orders = dao.fetchAllPayment(Order.class);
		for(Order order1:orders) {
			System.out.println(order1.getId());
			System.out.println(order1.getPayment().getPmode());
			System.out.println(order1.getPayment().getAmount());
			System.out.println(order1.getPayment().getPstatus());
			System.out.println(order1.getAmount());
			System.out.println(order1.getOrderDate());
		 
		
		}*/
	}
	@Test
	public void fetchData() {
		
		GenericDao dao=new GenericDao();
		List<Order> orders = dao.fetchAll(Order.class);
		for(Order order1:orders) {
			System.out.println(order1.getId());
			System.out.println(order1.getCustomer().getName());
			System.out.println(order1.getCustomer().getEmail());
			System.out.println(order1.getPayment().getPay_id());
			System.out.println(order1.getPayment().getPmode());
			System.out.println(order1.getPayment().getPstatus());
			System.out.println(order1.getAmount());
			System.out.println(order1.getOrderDate());
			
			
		}
		
		
	}

}
