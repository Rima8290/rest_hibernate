package com.lti.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;
import com.lti.entity.GenericDao;
import com.lti.entity.Payment;

public class PaymentDaoTest {
	@Test
	public void addTest() {
		Payment p=new Payment();
		p.setAmount(1900.0);
		p.setPstatus("Paid");
		p.setPmode("Debit");
		
		
		GenericDao dao=new GenericDao();
		dao.addPayment(p);
		
	}
}
