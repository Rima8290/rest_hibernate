package com.lti.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ACC")
public class Account {
 
	@Id
	@GeneratedValue
	@Column(name="ACNO")
	private long acno;
	
	private String name;
	
	@Column(name="AC_TYPE")
	private String type;
	private double balance;
	
	@OneToMany(mappedBy = "account")
	private Set<TransactionLog> transactionlog;

	public long getAcno() {
		return acno;
	}

	public void setAcno(long acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<TransactionLog> getTransactionlog() {
		return transactionlog;
	}

	public void setTransactionlog(Set<TransactionLog> transactionlog) {
		this.transactionlog = transactionlog;
	}
	
	
	
	

}
