package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

public class AccountDao extends GenericDao {

	public List<TransactionLog> fetchMiniStatement(long acno) {
		EntityManager em = null;
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();

			// Introducing JP_QL/HQL
			String ql = "select t from TransactionLog t where t.account.acno= :ac order by t.date desc";
			Query q = em.createQuery(ql);
			q.setParameter("ac", acno);
			q.setMaxResults(5);

			List<TransactionLog> list = q.getResultList();
			return list;
		}

		finally {
			em.close();
			emf.close();
		}

	}

	public List<Account> balCheck(double balance) {
		EntityManager em = null;
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();

			// Introducing JP_QL/HQL
			String ql = "select ac from Account ac where ac.balance>= :bal";
			Query q = em.createQuery(ql);
			q.setParameter("bal", balance);
			//q.setMaxResults(5);

			List<Account> list = q.getResultList();
			return list;
		}

		finally {
			em.close();
			emf.close();
		}

	}
	public List<Account> fetchAccountByActivity(String type,double amount) {
		EntityManager em = null;
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();

			// Introducing JP_QL/HQL
//transactionlog refers to the column name and not the class name we are referring in the TransactionLog table
			String ql = "select ac from Account ac inner join ac.transactionlog tx where tx.type = :tp and tx.amount >=:am";
			Query q = em.createQuery(ql);
			q.setParameter("tp", type);
			q.setParameter("am", amount);
			//q.setMaxResults(5);

			List<Account> list = q.getResultList();
			return list;
		}

		finally {
			em.close();
			emf.close();
		}

	}
}
