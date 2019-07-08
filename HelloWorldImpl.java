package com.lti.component;

//@Component
//@Scope("singleton")
public class HelloWorldImpl implements HelloWorld{
	
	public HelloWorldImpl() {
		System.out.println("constructor of HelloWorldImpl");
	}
	public String sayHello(String name) {
		return "Hello" + name;
        
	}

}
