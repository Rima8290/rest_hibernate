package com.lti.controller;

import java.util.List;

public interface Users {

	public void addUser(User user);

	public List<User> getUsers();
		
	public User fetch(String email);
		
}
