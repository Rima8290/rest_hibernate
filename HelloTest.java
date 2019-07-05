package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.CurrencyConverter;
import com.lti.component.HelloAgain;
import com.lti.component.HelloWorld;

public class HelloTest {
	
	public static void main(String[] args) {
		//loading Spring's IoC Container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

	   //accessing one of the bean
        HelloWorld hw = (HelloWorld) context.getBean("hw");
         System.out.println(hw.sayHello("riya"));
         
         CurrencyConverter cc = (CurrencyConverter) context.getBean("cc");
         System.out.println(cc.convertDollarToRupees(89));
         
         HelloAgain ca = (HelloAgain) context.getBean("ca");
         System.out.println(ca.sayHello("riya"));
         
	}
}
