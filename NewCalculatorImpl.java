package com.lti.component;

import org.springframework.stereotype.Component;

@Component("c1")
public class NewCalculatorImpl implements NewCalculator{

public int sum(int a, int b) {
		
		return a+b;
	}

	public int sub(int a, int b) {
		return a-b;
	}

}
