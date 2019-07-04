package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class CustomerDao {
	
	/*public void add(Customer c) {
		EntityManager em =null;
		EntityManagerFactory emf=null;
		
		try { //1-create EntityManagaerFactory object
		emf=Persistence.createEntityManagerFactory("oracle-pu");
		//2- Create/load EntityManager object
		 em= emf.createEntityManager();
		
		//3-Start Transactions
		
		EntityTransaction tx =em.getTransaction();
		tx.begin();
		
		em.persist(c);//persist method generates insert query and finds table from object class
		tx.commit();
		}
				
		finally {
		//Below code shld be in finally block
		em.close();
		emf.close();
		}
		
	}*/
	
	public Customer fetch(int cstId) {
		EntityManager em =null;
		EntityManagerFactory emf=null;
		
		 try {
				 emf=Persistence.createEntityManagerFactory("oracle-pu");
		        em= emf.createEntityManager();
			
				//Find Method generates select Query
				Customer c= em.find(Customer.class, cstId);
				return c;
		 }
		 
		 
			finally {	
				em.close();
				emf.close();
			}
		
	}
	public void insertOrUpdate(Customer c) {
		EntityManager em =null;
		EntityManagerFactory emf=null;
		
		try {
	    emf=Persistence.createEntityManagerFactory("oracle-pu");
		em= emf.createEntityManager();
		EntityTransaction ts=em.getTransaction();
		ts.begin();
		//Find Method generates select Query
		Customer cs=em.merge(c);//merge method can be used for insert as well as update
		ts.commit();
		
		}
		
		finally {
		em.close();
		emf.close();
		}
		
}
	
	public List<Customer> display() {
			EntityManager em =null;
			EntityManagerFactory emf=null;
			try {
		emf=Persistence.createEntityManagerFactory("oracle-pu");
		em= emf.createEntityManager();
	
		//Introducing JP_QL/HQL
		
		Query q=em.createQuery("select c from Customer as c ");
		List<Customer> list=q.getResultList();
		return list;
			}
		
		finally {
		em.close();
		emf.close();
		}
		
	
	}
	
public List<Customer> fetchCustomersByEmail(String email) {
	EntityManager em =null;
	EntityManagerFactory emf=null;
	 
	try {
		 emf=Persistence.createEntityManagerFactory("oracle-pu");
	    em= emf.createEntityManager();
	
		//Introducing JP_QL/HQL
		
		Query q=em.createQuery("select c from Customer as c where c.email like :em");
		q.setParameter("em", "%" +email + "%");
		//Query q=em.createQuery("select c from Customer as c where c.email like %?.%");
		List<Customer> list=q.getResultList();		
		return list;
	}
			
	finally {
		em.close();
	    emf.close();
	}

	}
}
