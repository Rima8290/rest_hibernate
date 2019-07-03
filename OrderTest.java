package com.lti.entity;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testInsert() {
		GenericDao dao = new GenericDao();
		Customer cust = (Customer)dao.showById(Customer.class, 45);

		Order order = new Order();
		order.setOrderDate(new Date());
		order.setAmount(89000);
		order.setCustomer(cust);
		dao.UpdateOrInsert(order);

	}

	@Test
	public void fetchOrders() {
		GenericDao dao = new GenericDao();
		List<Order> orders = dao.fetchAll(Order.class);
		for (Order order : orders) {
			System.out.println(order.getId());
			System.out.println(order.getAmount());
			System.out.println(order.getOrderDate());
			System.out.println(order.getCustomer().getEmail());
		}
	}
	@Test
	public void payInsert() {
		GenericDao dao = new GenericDao();
		Order order = (Order)dao.showById(Order.class,122);
	
		Payment pay = new Payment();
		
		pay.setAmount(order.getAmount());
		pay.setStatus("failed");
		pay.setM("paytm");

		dao.UpdateOrInsert(pay);


}
}