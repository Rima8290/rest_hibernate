package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CarPart;
import com.lti.component.CarPartsInventory;

public class CarPartsTest {

	@Test
	public void add() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cp= (CarPartsInventory)context.getBean("carPartsImpl4");
		
		//entity class object we don't create using spring
		CarPart carp=new CarPart();
		carp.setPartno(5);
		carp.setPartname("Seat");
		carp.setCarModel("Mahindra");
		carp.setQuantity(20);
		cp.addNewPart(carp);
		
		
	}
	/*
	@Test
	public void fetch() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cp= (CarPartsInventory)context.getBean("carPartsImpl3");
		for
*/
	@Test
	public void fetch() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		CarPartsInventory cp= (CarPartsInventory)context.getBean("carPartsImpl4");
        
		
		//CarPart carp=new CarPart();
		List<CarPart> list = cp.getAvailableParts();
		for(CarPart c : list) {
			System.out.println(c.getPartno());
			System.out.println(c.getPartname());
			System.out.println(c.getCarModel());
			System.out.println(c.getQuantity());
			
		//cp.getAvailableParts();
		}
		
 }
}
