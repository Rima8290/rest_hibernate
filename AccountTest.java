package com.lti.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;
import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.AccountDao;
import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;
import com.lti.entity.TransactionLog;
import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void addAcc() {
		
		AccountService a = new AccountService();
		Account acc = new Account();
		
		acc.setName("Riya");
		acc.setType("Current");
		acc.setBalance(50000);
		
		a.openAccount(acc);
		
		
	}

	@Test
	public void testwithdraw() {
		
		AccountService a = new AccountService();
		a.withdraw(102, 100);
		
		
	}

	@Test
	public void testDeposit() {
		
		AccountService a = new AccountService();
		a.withdraw(101, 200);
		
		
	}
	@Test
	public void testBalance() {
		
		AccountService a = new AccountService();
		
		double balance = a.checkBalance(101);
		System.out.println("Currnet balacne is:"+balance);
		
	}
	@Test
	public void testTransfer() {
		
		AccountService a = new AccountService();
		a.transfer(101, 102,300);
	}
	@Test
	public void testMiniStatement() {
		
		AccountDao ac = new AccountDao();
		List<TransactionLog> list =ac.fetchMiniStatement(101);
		for(TransactionLog t: list) {
			System.out.println(t.getTxno());
		}
	
}
	@Test
	public void balCheck() {
		
		AccountDao ac = new AccountDao();
		List<Account> list =ac.balCheck(500);
		for(Account t: list) {
			System.out.println(t.getAcno());
			System.out.println(t.getName());
			System.out.println(t.getType());
			
		}
	
}
	@Test
	public void accountByTransaction() {
		
		AccountDao ac = new AccountDao();
		List<Account> list =ac.fetchAccountByActivity("Savings", 100);
		for(Account t: list) {
			System.out.println(t.getAcno());
			System.out.println(t.getName());
			System.out.println(t.getType());
			
		}
	
}
}
