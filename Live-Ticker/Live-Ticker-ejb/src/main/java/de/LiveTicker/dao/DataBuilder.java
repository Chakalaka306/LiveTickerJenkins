package de.LiveTicker.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import de.LiveTicker.entities.User;

@Singleton
@Startup
public class DataBuilder {

	private static final Logger logger = Logger.getLogger(DataBuilder.class);

	@PersistenceContext
	EntityManager em;

	@EJB
	LiveTickerDAOLocal dao;

	@Resource
	private String username1, email1, password1, username2, email2, password2;

	@PostConstruct
	private void createTestData() {

		// erzeuge ein paar Beispieldaten zu Kunden und Konten, falls sie noch
		// nicht in der DB vorhanden sind.
		User user1 = dao.findUserByName(username1);

		if (user1 == null) {
			// Kunde noch nicht vorhanden, also mit 2 neuen Konten anlegen:
			user1 = new User(username1, email1, password1);
			em.persist(user1);

		}
		User user2 = dao.findUserByName(username2);
		if (user2 == null) {

			user2 = new User(username2, email2, password2);
			em.persist(user2);

			logger.info("Neu angelegt:" + user1);
			logger.info("Neu angelegt: " + user2);
		}
	}

}
