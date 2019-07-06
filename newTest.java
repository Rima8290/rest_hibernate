package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.ATM;
import com.lti.component.HelloInterface;

public class newTest {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		ATM a =(ATM) context.getBean("HDFC");//bean id
		a.withdraw();
		
	}
}
