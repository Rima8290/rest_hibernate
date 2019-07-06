package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("c2") //alternative to <bean id=".." class="..">
public class CurrencyConverter {
	
	  @Autowired  //field injection
		private Dollar dl;
		
	  public void converter(double value) {
	  System.out.println("The converted value is "+ value*dl.CurrentDollarValue());
	}

}
