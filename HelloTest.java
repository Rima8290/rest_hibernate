package com.lti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.component.Calculator;
import com.lti.component.CurrencyConverter;
import com.lti.component.HelloInterface;
import com.lti.component.HelloWorld;
import com.lti.component.Lazy;
import com.lti.component.NewCalculator;
import com.lti.component.TextEditor;

public class HelloTest {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//accessing one of the bean
		HelloInterface hw=(HelloInterface) context.getBean("hw");//bean id
		System.out.println(hw.sayHello("Hardy"));
		
		Calculator calc=(Calculator) context.getBean("cal");
		System.out.println("sum is:"+ calc.sum(40,30));
		System.out.println("sub is:"+ calc.sub(40,30));
		
		CurrencyConverter cc = (CurrencyConverter) context.getBean("c2");
		cc.converter(12.0);
		
		Lazy lz=(Lazy) context.getBean("lz");
		System.out.println(lz.lazyMan("Harry"));
		
		NewCalculator cal=(NewCalculator) context.getBean("c1");
		System.out.println("sum is:"+ cal.sum(40,30));
		System.out.println("sub is:"+ cal.sub(40,30));
		
		TextEditor txE=(TextEditor) context.getBean("txE");//bean id
		txE.load("a.txt ");
		
	}

}
