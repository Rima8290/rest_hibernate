package com.lti.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(path="/login.lti", method=RequestMethod.POST)
    public String execute(@RequestParam("username") String username,
    		              @RequestParam("password") String password,
    		              Map<String, Object> model) {
		
	if(username.equals("riya") && password.equals("123")) {
	  model.put("loggedInUsername", username);	
		return "welcome.jsp";
	}
	else {
		model.put("message", "Invalid username/password");
		return "login.jsp";
		
	}
}
}
