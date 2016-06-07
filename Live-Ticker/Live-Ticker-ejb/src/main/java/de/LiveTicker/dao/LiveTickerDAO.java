package de.LiveTicker.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.LiveTicker.entities.User;
import de.LiveTicker.entities.LiveTickerSession;;

@Stateless
public class LiveTickerDAO implements LiveTickerDAOLocal {

	@PersistenceContext
	EntityManager em;
	

	public LiveTickerSession findSessionById(int id) {
    	return em.find(LiveTickerSession.class, id);
    }
	public int createSession(User user) {
		LiveTickerSession newSession = new LiveTickerSession(user);
        em.persist(newSession);
        return newSession.getId();
    }
	public void closeSession(int id) {
		LiveTickerSession session = em.find(LiveTickerSession.class, id);
    	if (session != null) {
    		em.remove(session);
    	}
    }
	public User findUserByName(String userName) {
    	List<?> results = em.createQuery("SELECT a FROM Account a WHERE a.userName LIKE :accName")
    	                 .setParameter("accName", userName)
    	                 .getResultList();
    	if (results.size()==1) {
    	    return (User) results.get(0);
    	}
    	else {
    		return null;
    	}
    }
	public User findUserByEmail(String email) {
    	List<?> results = em.createQuery("SELECT a FROM Account a WHERE a.email LIKE :accEmail")
    	                 .setParameter("accEmail", email)
    	                 .getResultList();
    	if (results.size()==1) {
    	    return (User) results.get(0);
    	}
    	else {
    		return null;
    	}
    }	
	public User createUser(String userName, String password, String email) {
		if(findUserByName(userName) == null && findUserByEmail(email) == null) {
			User user = new User(userName, password, email);
			em.persist(user);	
			return user;
		}
		else {
			//Return null, if username already exists.
			return null;
		}
	}
}
