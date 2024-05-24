package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User user) {
		// user : transient(neither associated with L1 cache nor in DB)
		String mesg = "Registration failed !!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();

		// L1 cache is created -- EMPTY
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();

		try {
			// 3. Session API -- public void persist(Object o) throws HibExc
			session.persist(user); // user : persistent
			tx.commit();
			// rec will be inserted in db
			mesg = "User registered successfully , with ID =  " + user.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}

		// user - DETACHED (doesn't exist in L1 cache , BUT has DB identity)
		return mesg;
	}

}
