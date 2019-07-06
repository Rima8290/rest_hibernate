package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("HDFC")
public class AtmImpl implements ATM{


	 @Autowired  //field injection
	// @Qualifier("bank name") when 2 classes are implementing the same interface
	private Bank bi;
	public void withdraw() {
	bi.communicate();
		
	}
}
