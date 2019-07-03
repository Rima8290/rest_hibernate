package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerDao {
	
	/*public void databaseAdd(Customer customer) {
		
		//Step1. Load/create entity/ManagerFactory object
		//During this step, META-INF Persistence.xml is read
		EntityManagerFactory emf =null; 
		//Step2. Load/Create EntityManager Object
		EntityManager em =null; 
	try {	emf = Persistence.createEntityManagerFactory("oracle-pu");
	        em = emf.createEntityManager();
		//Step3. Start/Participate in a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Now we can insert/update/delete/select whatever we want
		em.persist(customer); //persist method generates insert query
		
		tx.commit();
	}
		//below code should be in finally block
	finally {	
		
		em.close();
		emf.close();
	}
		
	}
	*/
	
public Customer databaseShow(int custId) {
		
		EntityManagerFactory emf = null; 
		EntityManager em = null; 
		try{
			emf= Persistence.createEntityManagerFactory("oracle-pu");
		
		em = emf.createEntityManager();
		//find method generates select query
		Customer c = em.find(Customer.class, custId); //1st parameter is table name
		return c;
		}
		
		finally {
		em.close();
		emf.close();
		}
		
		
	}
public void databaseUpdate(Customer customer) {// for insert or update
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	try{
		 emf =Persistence.createEntityManagerFactory("oracle-pu");
		 em = emf.createEntityManager();
	     EntityTransaction tx = em.getTransaction();
	     tx.begin();
	

	    em.merge(customer);//For insert and update 
	
	    tx.commit();
	  }
	finally {
	em.close();
	emf.close();
	}
	
}
public List<Customer> selectAll() {
	
	EntityManagerFactory emf =null; 
	EntityManager em = null;
	try { 
		emf = Persistence.createEntityManagerFactory("oracle-pu");
         em = emf.createEntityManager();	
	
	//introducing JP-QL
	Query q=em.createQuery("select c from Customer c ");
	List<Customer> list=q.getResultList();
	return list;
	}
	
	finally {
	em.close();
	emf.close();
	}
	
	
}
public List<Customer> fetchCustomerByEmail(String email) {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	try {
	emf= Persistence.createEntityManagerFactory("oracle-pu");
	 em = emf.createEntityManager();
	//introducing JP-QL
	Query q=em.createQuery("select c from Customer c where c.email like :em");
	q.setParameter("em", "%" + email + "%");
	//q.setParameter(0, email);
	List<Customer> list=q.getResultList();
	return list;
	}
	finally {
	em.close();
	emf.close();
	}
	
	
}
}