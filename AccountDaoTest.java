package com.lti.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Activity;
import com.lti.entity.Customer;
import com.lti.entity.GenericDao;
import com.lti.entity.Order;
import com.lti.service.AccountService;

public class AccountDaoTest {

	@Test
	public void openAccount() {
		
	         AccountService acServ=new AccountService();
	         Account ac=new Account();
	        
	         ac.setName("Majrul");
	         ac.setTyp("Current");
	         ac.setBalance(20000.0);
	         acServ.openAccount(ac);
	
}
	@Test
	public void withdrawAmount() {
		
	         AccountService acServ=new AccountService();
	         acServ.withdraw(145, 1000);
	        
	
}
	@Test
	public void depositAmount() {
		
	         AccountService acServ=new AccountService();
	         acServ.deposit(157, 5000);
	        
	
}
	@Test
	public void transferAmount() {
		
	         AccountService acServ=new AccountService();
	         acServ.transfer(157, 145, 3000);
	        
	
}
	@Test
	public void checkAmount() {
		
	         AccountService acServ=new AccountService();
	         double amt=acServ.checkBalance(157);
	         System.out.println("Your updated balance is : " + amt);
}
	
	@Test
	public void fetchStatement() {
		
	         AccountService acServ=new AccountService();
	         List<Activity> sng=acServ.miniStatement(141);
	         for(Activity ac : sng)
	         {
	        	
	         System.out.println(" Name :" + ac.getAccount().getName());
	         System.out.println(" Your account no is :" + ac.getAccount().getAcno());
	         System.out.println("your transaction no is : " + ac.getTxno());
	         System.out.println("your transaction date is : " + ac.getDat());
	         System.out.println("your transaction amount is : " + ac.getAmount());
	         System.out.println("your transaction type is : " + ac.getTyp());
	         
	         }
}
	@Test
	public void fetchByBal() {
		
	          AccountService acServ=new AccountService();
	          List<Account> amt=acServ.thousandOrMore(1000);
	         for(Account a : amt)
	         {
	        	
	         System.out.println(a.getName());
	         System.out.println(a.getAcno());
	         System.out.println(a.getBalance());
	         System.out.println(a.getTyp());
	         
	         
	         }
}
	@Test
	public void fetchByWithdrawType() {
		
	          AccountService acServ=new AccountService();
	          List<Account> amt=acServ.withdrawnHundred("withdraw", 1000);
	         for(Account a : amt)
	         {
	         /*System.out.println(a.getTxno());	
	         System.out.println(a.getAmount());
	         System.out.println(a.getAccount().getName());
	         System.out.println(a.getTyp());
	         System.out.println(a.getDat());*/
	        	 System.out.println(a);
	         
	         
	         }
}
}
