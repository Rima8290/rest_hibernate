package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ORDER")
public class Order {
	
	/*@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", amount=" + amount + ", customer=" + customer
				+ ", payment=" + payment + "]";
	}
*/
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private int id;
	
	private Date orderDate;
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="CUST_ID") //fk
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="PAY_ID", unique = true)
	private Payment payment;

	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
