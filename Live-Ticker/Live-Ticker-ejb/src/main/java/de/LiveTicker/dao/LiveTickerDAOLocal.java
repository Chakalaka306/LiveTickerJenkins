package de.LiveTicker.dao;

import javax.ejb.Local;

import de.LiveTicker.entities.Session;

@Local
public interface LiveTickerDAOLocal {

	public Session findSessionById(int id);

}
