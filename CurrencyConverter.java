package com.lti.component;

import org.springframework.stereotype.Component;

@Component("cc") //alternative to <bean id="..." class="...">
public class CurrencyConverter {
	
	  public double convertDollarToRupees( double dollars) {
		return dollars * 68.44;
	}
}
