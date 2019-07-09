package com.lti.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component("usersImpl")
public class UserImpl implements Users{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional // for begin and commit
    public void addUser(User user) {
		entityManager.persist(user);
		}

	public List<User> getUsers() {
	
		Query q=entityManager.createQuery("select u from User u");
		List<User> list=q.getResultList();
		return list;
  
  }
 
	public User fetch(String email) {
		User u= entityManager.find(User.class, email);
		return u;
	}
}
