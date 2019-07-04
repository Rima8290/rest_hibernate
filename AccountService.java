package com.lti.service;

import java.util.Date;

import com.lti.entity.Account;
import com.lti.entity.AccountDao;
import com.lti.entity.AccountDao;
import com.lti.entity.Order;
import com.lti.entity.Payment;
import com.lti.entity.TransactionLog;


import java.util.List;

import javax.transaction.Transaction;

public class AccountService {

	public void openAccount(Account acc) {
		AccountDao dao = new AccountDao();
		dao.save(acc);
	}
	
	public void withdraw(long acno,double amount ) {
		AccountDao dao = new AccountDao();
		Account account=(Account)dao.fetchById(Account.class,acno);
		TransactionLog trans = new TransactionLog();
		
		if(account.getBalance()<amount) {
			System.out.println("Insufficient balance!!");
			System.out.println("Currnet balance is"+account.getBalance());
		}
		else {
		double balance = account.getBalance();
		balance -= amount;
		trans.setAmount(amount);
		trans.setDate(new Date());
		trans.setType(account.getType());
		trans.setAccount(account);
		account.setBalance(balance);
		
		dao.save(account);
		dao.save(trans);
		System.out.println("Currnet balance is"+balance);
		}
	}
	
	public void deposit(long acno, double amount) {
		
		AccountDao dao = new AccountDao();
		Account account=(Account)dao.fetchById(Account.class,acno);
		TransactionLog trans = new TransactionLog();
		
		double balance = account.getBalance();
		balance += amount;
		trans.setAmount(amount);
		trans.setDate(new Date());
		trans.setType(account.getType());
		trans.setAccount(account);
		account.setBalance(balance);
		
		dao.save(account);
		dao.save(trans);
		System.out.println("Currnet balance is"+balance);
    } 
	
	public void transfer(long fromAcno, long toAcno, double amount) {
		
		AccountDao dao = new AccountDao();  
		TransactionLog trans1 = new TransactionLog();
		TransactionLog trans2 = new TransactionLog();
		Account account1=(Account)dao.fetchById(Account.class,fromAcno);
		Account account2=(Account)dao.fetchById(Account.class,toAcno);
	
	if(checkBalance(fromAcno)<amount) {
		System.out.println("Ammount is not sufficient"+checkBalance(fromAcno));
	}
	
	else {
		double balance = account1.getBalance();
		balance -= amount;
		account1.setBalance(balance);
		double balance2 = account2.getBalance();
		balance2 += amount;
		account2.setBalance(balance2);
		trans1.setDate(new Date());
		trans1.setType("Withdraw");
		trans1.setAccount(account1);
		account1.setBalance(balance);
		
		trans2.setDate(new Date());
		trans2.setType("Deposit");
		trans2.setAccount(account2);
		account2.setBalance(balance2);
		
		dao.save(account1);
		dao.save(trans1);
		dao.save(account2);
		dao.save(trans2);
		System.out.println("Updated  balance is"+account1.getBalance());
		System.out.println("Updated  balance is"+account2.getBalance());
		
	}
	}
	
	public double checkBalance(long acno) {
		
		AccountDao dao = new AccountDao();
		Account account=(Account)dao.fetchById(Account.class,acno);
		return account.getBalance();
		
		
	}
	public List<TransactionLog> ministatement(long acno){
		AccountDao dao = new AccountDao();
		List<TransactionLog> list=dao.fetchMiniStatement(acno);
		return list;
		 
		
	}
	public List<Account> balCheck(double balance){
		AccountDao dao = new AccountDao();
		List<Account> list=dao.balCheck(balance);
		return list;
		 
		
}
	public List<Account> fetchAccountByActivity(String type, double amount){
		AccountDao dao = new AccountDao();
		List<Account> list=dao.fetchAccountByActivity(type, amount);
		return list;
		 
		
}
}
