package de.LiveTicker.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import de.LiveTicker.entities.Session;

@Stateless
public class LiveTickerDAO implements LiveTickerDAOLocal {

	@PersistenceContext
	EntityManager em;
	

	public Session findSessionById(int id) {
    	return em.find(Session.class, id);
    }
	
}
