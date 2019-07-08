package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.Atm;
import com.lti.component.Calculator;
import com.lti.component.CurrencyConverter;
import com.lti.component.HelloWorld;
import com.lti.component.TextEditor;


public class HelloTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Calculator cal=(Calculator) context.getBean("calc");
		for(int i=0; i<5; i++) {
		HelloWorld hk=(HelloWorld) context.getBean("hk");
		System.out.println(hk.sayHello(" Sneha"));
		}
		CurrencyConverter cc=(CurrencyConverter) context.getBean("cc");
		System.out.println(cc.convertDollarsToRupees(25));
	
		System.out.println(cal.CalcAdd(100,2));
		TextEditor tx=(TextEditor) context.getBean("txtedit");
		tx.load("Document goes here");
		
		Atm at = (Atm) context.getBean("hdfcatm");
		System.out.println(at.withdraw(500));
		
	}}
