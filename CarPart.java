package com.lti.component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CARPARTS")
public class CarPart {
	
    @Id 									
	
	private int partno;
	private String partname;
	private String carModel;
	private int quantity;
	
	public int getPartno() {
		return partno;
	}
	public void setPartno(int partno) {
		this.partno = partno;
	}
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
