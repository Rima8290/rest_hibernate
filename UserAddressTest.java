package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.entity.Address;
import com.lti.entity.GenericDao;
import com.lti.entity.User;
import com.lti.entity.UserDao;

public class UserAddressTest {

	@Test
	public void addUser( ) {
        User user = new User();
		GenericDao dao = new  GenericDao(); 
		user.setName("Sneha");
		user.setEmail("sneha@gmail.com");
		
		dao.save(user);
	
	}
@Test
public void addAddressForExisitingUser() {
	GenericDao dao = new GenericDao();
	User user=(User)dao.fetchByPk(User.class, 228);
	Address address = new Address();
	
	address.setCity("Ooty");
	address.setState("Tamil Nadu");
	address.setPincode(123456);
	address.setUser(user);
	
	dao.save(address);
}
@Test
public void addUserAndAdressTogether() {  
	 
	    User user = new User();
		user.setName("Syed");
		user.setEmail("syed@gmail.com");
		
		Address address = new Address();
		address.setCity("Chennai");
		address.setState("Tamil Nadu");
		address.setPincode(123445);
		
		user.setAddress(address);
		address.setUser(user);

		GenericDao dao = new GenericDao();
		dao.save(user);
		
}
        @Test
        public void fetchUserAndAddressBoth() {
        	GenericDao dao= new GenericDao();
        	User user=(User)dao.fetchByPk(User.class, 228);
        	System.out.println(user.getName());
        	System.out.println(user.getEmail());
        	
        	Address add =  user.getAddress(); //eager fetching, this will fetch the address of the user also
        	System.out.println(add.getCity());
        	System.out.println(add.getState());
        	System.out.println(add.getPincode());
        	
        	
        	
        }

}
