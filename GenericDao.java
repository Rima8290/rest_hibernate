package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDao {

	public void UpdateOrInsert(Object obj) { // for insert or update

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			em.merge(obj);// For insert and update

			tx.commit();
		} finally {
			em.close();
			emf.close();
		}

	}

	public Object showById(Class classname, Object id) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");

			em = emf.createEntityManager();
			// find method generates select query
			//Object obj = em.find(Object.class, id); // 1st parameter is table name
			Object obj = em.find(classname, id);
			return obj;
		} 

		finally {
			em.close();
			emf.close();
		}

	}

	public <E> List<E> fetchAll(Class<E> clazz) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em = emf.createEntityManager();

		// introducing JP-QL
		Query q = em.createQuery("select obj from " + clazz.getName() + " as obj ");
		List<E> list = q.getResultList();

		em.close();
		emf.close();
		return list;
	}
}