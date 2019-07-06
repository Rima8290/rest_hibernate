package com.lti.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("txE")
public class TextEditor {

	//DI
	@Autowired  //field injection
	private SpellChecker sp;
	public void load(String doc) {
		System.out.println(doc +" "+"uploaded");
		//SpellChecker s = new SpellChecker();
		sp.spellCheck(doc);
		
	}
	
	
}
