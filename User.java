package com.lti.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TABLE_USERS")
public class User {
	
   private String name;
   private int age;
   
   @Id
   private String email;
   private String city;
   private String profilePicFilename;
   
   
   
   public String getProfilePicFilename() {
	return profilePicFilename;
}

public void setProfilePicFilename(String profilePicFilename) {
	this.profilePicFilename = profilePicFilename;
}

@Override
   public String toString() {
   	return "User [name=" + name + ", age=" + age + ", email=" + email + ", city=" + city + "]";
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
