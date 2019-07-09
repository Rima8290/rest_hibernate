package com.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

@Autowired
Users us;

	@RequestMapping(path="/register.lti", method = RequestMethod.POST)
    public String execute(UserDTO userDTO) {  //store the data in an object
		String path = "d:/uploads/";
		String filename = userDTO.getName() + "-" + userDTO.getProfilePic().getOriginalFilename();
		String finalpath = path +filename;
		try {
			userDTO.getProfilePic().transferTo(new File(finalpath));
			} catch(IOException e) {
				e.printStackTrace();
			}
		
		//Code to store data in database
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setAge(userDTO.getAge());
		user.setProfilePicFilename(filename);
	us.addUser(user);
		
		List<User> list = us.getUsers();
		for(User c : list) {
			System.out.println(c.getName());
			System.out.println(c.getAge());
			System.out.println(c.getEmail());
			System.out.println(c.getCity());
		}
		
		
		return "register.jsp";
		
	}
	
	
	@RequestMapping(path="/searchUser.lti", method = RequestMethod.POST)
	public String search(@RequestParam("email") String email,
			              Map<String, Object> model){
		User user = us.fetch(email);
		model.put("userData", user);
		return "displayUser.jsp";
	}

}
