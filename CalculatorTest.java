package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.Calculator;
import com.lti.component.HelloWorld;

public class CalculatorTest {


		public static void main(String[] args) {
			//loading Spring's IoC Container
	        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		   //accessing one of the bean
	        Calculator cal = (Calculator) context.getBean("cal");
	    cal.add(3, 8);
	    cal.sub(9, 8);
		}
}
