package com.lti.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;
import com.lti.entity.GenericDao;

public class CustomerDaoTest {

	@Test
	public void addTest() {
		try {
		Customer c=new Customer();
		c.setName("Sneha");
		c.setEmail("sneha@abc.com");
		Date d;
		d = new SimpleDateFormat("dd/MM/yyyy").parse("27/10/1997");
		c.setDob(d);
		c.setCity("Palakkad");
		CustomerDao dao=new CustomerDao();
		dao.insertOrUpdate(c);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void fetchTest() {
		CustomerDao dao=new CustomerDao();
		Customer c=new Customer();
		c=dao.fetch(1);
		System.out.println(c);
	}
	@Test
	public void testUpdate() {
		
		CustomerDao dao=new CustomerDao();
		Customer c=dao.fetch(1);
		c.setCity("Konkan");
			dao.insertOrUpdate(c);
			System.out.println("Updated");  
		
		
	}
	
    @Test
	public void testdisplay(){
		
		CustomerDao dao=new CustomerDao();
		List <Customer>list=dao.display();
		for(Customer li:list) {
			System.out.println(li.getName());
			System.out.println(li.getEmail());
			System.out.println(li.getDob());
			System.out.println(li.getCity());
		}
		
	}
    
    //nfetch all using generic dao
    @Test
	public void displayData(){
		
		GenericDao dao=new GenericDao();
		List<Customer> orders =dao.fetchAll(Customer.class);
		for(Customer li:orders) {
			System.out.println(li.getName());
			System.out.println(li.getEmail());
			System.out.println(li.getDob());
			System.out.println(li.getCity());
		}
		
	}
    
    @Test
    public void testemail() {
    	CustomerDao dao=new CustomerDao();
    	List <Customer>list=dao.fetchCustomersByEmail("abc");
    	for(Customer li:list) {
			System.out.println(li.getName());
			System.out.println(li.getEmail());
			System.out.println(li.getDob());
			System.out.println(li.getCity());
		}
		
    }

}
