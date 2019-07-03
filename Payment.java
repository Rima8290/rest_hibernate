package com.lti.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TBL_PAYMENT")
public class Payment {

	@Id
	@GeneratedValue
	@Column(name = "PAYMENT_ID")
	private int id;
	private double amount;
	private String status;
	private String m;    //-------------------- 'm' mode
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	
	
}
