package com.lti.training;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;




@Component("empDetails")
public class EmployeeDetailsImpl implements  EmployeeDetails {

	  
		@PersistenceContext
		private EntityManager entityManager;
		
		@Transactional 
		public void addDetails(Employee emp) {
		
		entityManager.persist(emp);
	}

	public List<Employee> getDetails() {
		
		Query q=entityManager.createQuery("select e from Employee e where e.salary > :sal");
		q.setParameter("sal",23000);
		List<Employee> list = q.getResultList();
		return list;
		
	}

}
