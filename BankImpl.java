package com.lti.component;

import org.springframework.stereotype.Component;

@Component("ICICI")
public class BankImpl implements Bank {

	public void communicate() {
		
		System.out.println("Amount is available");
	}
}
