package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public String addNameAndDescription(Category category) {
		String msg = "category adding failed";
		// 1. get session from SF (get current session)
		Session session = getFactory().getCurrentSession();
		// 2. begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			Serializable userId = session.save(category);
			tx.commit();
			System.out.println("User Id of serializable categoty is "+userId);
			msg = "category add successfully";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re thow the exception to the caller
			throw e;
		}
		return msg;
	}



}