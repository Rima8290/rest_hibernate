package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PAYMENT")
public class Payment {
	
	@Override
	public String toString() {
		return "Payment [pay_id=" + pay_id + ", amount=" + amount + ", pmode=" + pmode + ", pstatus=" + pstatus + "]";
	}
	@Id
	@GeneratedValue
	@Column(name="PAY_ID")
	private int pay_id;
	private double amount;
	private String pmode;
	private String pstatus;
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	
	

}
