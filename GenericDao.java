package com.lti.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDao {//BaseDao,CommonDao,SabkaDao,...
	
	public void save(Object obj) {
		EntityManager em =null;
		EntityManagerFactory emf=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("oracle-pu");
			em= emf.createEntityManager();
			EntityTransaction ts=em.getTransaction();
			ts.begin();
			//Find Method generates select Query
			em.merge(obj);//merge method can be used for insert as well as update
			ts.commit();
		}
		
		finally {
			em.close();
			emf.close();
		}

	}
	public Object fetchById(Class classname, Object sId) {
		EntityManager em =null;
		EntityManagerFactory emf=null;
		
		 try {
				 emf=Persistence.createEntityManagerFactory("oracle-pu");
		        em= emf.createEntityManager();
			
				//Find Method generates select Query
				Object obj= em.find(classname, sId);
				return obj;
		 }
		 
		 
			finally {	
				em.close();
				emf.close();
			}
		
	}
	
	
	
	
	

	
	
	
	
	
}
