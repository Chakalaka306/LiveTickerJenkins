package de.LiveTicker.dao;

import javax.ejb.Local;

import de.LiveTicker.entities.*;


@Local
public interface LiveTickerDAOLocal {

	public LiveTickerSession findSessionById(int id);
	public int createSession(User user);
	public void closeSession(int id);
	public User findUserByName(String username);
	public User findUserByEmail(String email);
	public User createUser(String userName, String password, String email);
	
	
}
