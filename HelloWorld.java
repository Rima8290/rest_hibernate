package com.lti.component;

import org.springframework.stereotype.Component;


public class HelloWorld implements HelloInterface {

	public String  sayHello(String name) {
		return "Hello " + name;
		
	}
}
