package com.lti.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

//@Entity
//@Table(name="TABLE_USERS")
public class UserDTO {   //----------Data Transfer Object
	
   private String name;
   private int age;
   
   //@Id
   private String email;
   private String city;
   private MultipartFile profilePic;
   
   
   public MultipartFile getProfilePic() {
	return profilePic;
}

public void setProfilePic(MultipartFile profilePic) {
	this.profilePic = profilePic;
}
 
   public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}


}
