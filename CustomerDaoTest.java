package com.customerdao.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

public class CustomerDaoTest {

	@Test
	public void testAdd() throws ParseException {
		Customer c = new Customer();
		c.setName("Harry");
		c.setEmail("Harka@gmail.com");
		c.setCity("NCR");
	
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		  String d="15/05/1995";
		Date dt=sdf.parse(d);
		//java.sql.Date dob=new java.sql.Date(dt.getTime());
		//c.setDateOfBirth(dateOfBirth); //try this on your own
		c.setDateOfBirth(dt);
		
		CustomerDao dao = new CustomerDao();
		dao.databaseAdd(c);
	}
	
	@Test
	public void testFetch() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databaseShow(1);
		
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
	}
	
	@Test
	public void getResultList() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cust = dao.selectAll();
		for(Customer customer: cust){
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getDateOfBirth());
			System.out.println(customer.getCity());
		}
		
	}
	
	@Test
	public void testUpdate() {
		CustomerDao dao = new CustomerDao();
		Customer cust = dao.databaseShow(3);
		cust.setCity("Chennai");
		dao.databaseUpdate(cust);
	}
	@Test
	public void testFetchByEmail() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cust = dao.fetchCustomerByEmail("dhoka");
		for(Customer customer: cust){
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getDateOfBirth());
			System.out.println(customer.getCity());
		}
	}

}
