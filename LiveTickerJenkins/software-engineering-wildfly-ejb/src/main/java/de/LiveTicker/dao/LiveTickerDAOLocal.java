package de.LiveTicker.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import de.LiveTicker.entities.*;

/**
 * 
 * @author Dominik Teipel
 *
 */
@Local
public interface LiveTickerDAOLocal {

	public LiveTickerSession findSessionById(int id);
	public int createSession(User user);
	public void closeSession(int id);
	public User findUserByName(String username);
	public User findUserByEmail(String email);
	public User createUser(String userName, String password, String email);
	
	public Event findEventById(int id);
	public Game findGameById(int id);
	
	public Event createEvent(int gameid,int art,int team,String reason,int min);
	public Game createGame(Team team1,Team team2,Date anstoß);
	
	public Team findTeamByID(int id);
	public Team findTeamByName(String teamName);
	
	public void addFavorites(User user,Team newTeam);
	public void deleteFavorites(User user,int id);
	public List<User> displayFavorites(User user);
	
	public Team displayLiga(String liga);
	
	
}
