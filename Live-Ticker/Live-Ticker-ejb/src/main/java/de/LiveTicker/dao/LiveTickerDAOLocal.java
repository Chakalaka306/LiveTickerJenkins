package de.LiveTicker.dao;

import javax.ejb.Local;

import de.LiveTicker.entities.*;


@Local
public interface LiveTickerDAOLocal {

	public Session findSessionById(int id);
	public int createSession(Account user);
	public void closeSession(int id);
	public Account findAccountByName(String username);
	public Account findAccountByEmail(String email);
	public Account createAccount(String userName, String password, String email);
	
}
