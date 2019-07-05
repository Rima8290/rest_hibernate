package com.lti.component;

import org.springframework.stereotype.Component;

@Component("ca")
public class HelloAgain {


    public String sayHello(String name) {
	       return "Hello!!!!! " + name;
}
}
