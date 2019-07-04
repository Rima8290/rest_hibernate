package com.lti.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.TransactionLog;

public class AlbumDao extends GenericDao {

	public List<Album> fetchAlbum(int year) {
		EntityManager em = null;
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();

			// Introducing JP_QL/HQL
			String ql = "select al from Album al  where al.year = :yy";
			Query q = em.createQuery(ql);
			q.setParameter("yy", year);
			//q.setMaxResults(5);

			List<Album> list = q.getResultList();
			return list;
		}

		finally {
			em.close();
			emf.close();
		}

	}
	public List<Songs> fetchRecentSongs(int id) {
		EntityManager em = null;
		EntityManagerFactory emf = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-pu");
			em = emf.createEntityManager();

			// Introducing JP_QL/HQL
			String ql = "select s from Songs s where s.id = :id";
			Query q = em.createQuery(ql);
			q.setParameter("id", id);
			q.setMaxResults(2);

			List<Songs> list = q.getResultList();
			return list;
		}

		finally {
			em.close();
			emf.close();
		}

	}
	

}
