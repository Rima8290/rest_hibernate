package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTION")
public class Transaction {
	
	@Id//primary key
	@GeneratedValue//generated automatically
	@Column(name="TX_ID")
	private long txno;
	
	@Column(name="TX_DATE")
	private Date date;
	
	@Column(name="TX_TYPE")
	private String type;
	private double amount;
 
	@ManyToOne
	@JoinColumn(name = "ACC_ID")//fk
	private Account account;


	public long getTxno() {
		return txno;
	}


	public void setTxno(long txno) {
		this.txno = txno;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	
}
