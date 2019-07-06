package com.lti.component;

import org.springframework.stereotype.Component;

@Component("sp")
public class SpellChecker {

	public void spellCheck(String doc) {
		System.out.println("spell checker!!");
	}
}
