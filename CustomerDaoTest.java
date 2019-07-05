package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

public class CustomerDaoTest {

	@Test
	public void testAdd() {
		Customer c = new Customer();
		c.setName("godi");
		c.setEmail("godi@gmail");
		c.setCity("kerala");
	    //temporalValues.setLocalDate(LocalDate.parse("2017-11-15"));
		
			/* c = new Customer();
				c.setName("sneha");
				c.setEmail("sneha@gmail.com");
				c.setCity("ooty");
				
				
					 c = new Customer();
						c.setName("syed");
						c.setEmail("syed@gmail.com");
						c.setCity("chennai");
						
						 c = new Customer();
							c.setName("riya");
							c.setEmail("riya@gmail.com");
							c.setCity("mumbai");*/
			CustomerDao dao = new CustomerDao();
            dao.update(c);
		}
	
	@Test
	public void testFetch() {
		CustomerDao dao = new CustomerDao();
		List<Customer> cust = dao.fetchAll("gmail");
		
		for(Customer c : cust) {
			System.out.println(c.getName());
			System.out.println(c.getEmail());
			//System.out.println(cust.getDateOfBirth());
			System.out.println(c.getCity());
		}
	}
	@Test
	public void testupdate() {
		CustomerDao dao = new CustomerDao();
	//	Customer cust = dao.fetchAll(1);

	/*	cust.setCity("delhi");
		dao.update(cust);*/

	}
}
