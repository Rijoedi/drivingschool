package com.drivingschool.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.drivingschool.model.User;

public class UserDao {
	
	public boolean exist(User user) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<User> query = em.createQuery(
				"select u from User u "
				+ "where u.user = :pUser and u.password = :pPassword", User.class);
		
		query.setParameter("pUser", user.getUser());
		query.setParameter("pPassword", user.getPassword());
		
		try {
			User result = query.getSingleResult();
		} catch(NoResultException ex) {
			return false;
		}
		
		em.close();
		
		return true;

	}

}
