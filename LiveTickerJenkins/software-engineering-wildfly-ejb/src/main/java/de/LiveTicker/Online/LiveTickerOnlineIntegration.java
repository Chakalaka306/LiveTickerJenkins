package de.LiveTicker.Online;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;
import de.LiveTicker.dao.*;
import de.LiveTicker.dto.*;
import de.LiveTicker.entities.*;
import de.LiveTicker.util.DtoAssembler;

/**
 * 
 * @author Dominik Teipel
 *
 */

@WebService
@WebContext(contextRoot = "/software-engineering-wildfly")
@Stateless
public class LiveTickerOnlineIntegration {

	private static final Logger logger = Logger.getLogger(LiveTickerOnlineIntegration.class);
	/**
	 * EJB für den Datenzugriff
	 */
	@EJB
	private LiveTickerDAOLocal dao;

	/**
	 * EJB zur Erzeugung von DataTransferObjects
	 */
	@EJB
	private DtoAssembler dtoAssembler;

	@EJB
	private OutputRequesterBean outputRequester;

	/**
	 * Holt anhand der Session-ID das zugehörige Session-Objekt.
	 * 
	 * @param sessionId
	 * @return
	 * @throws NoSessionException
	 */
	private LiveTickerSession getSession(int sessionId) throws NoSessionException {
		LiveTickerSession session = dao.findSessionById(sessionId);
		if (session == null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}

	/**
	 * Methode für den Login eines bestehenden Accounts
	 * @param userName
	 * @param passWord Password des Benutzers
	 * @return UserLoginResponse wird bei erfolgreichem login zurückgegeben
	 * @throws InvalidLoginException
	 *             wird geworfen bei fehlerhaftem login, da E-Mail oder Password
	 *             des Benutzers falsch sind
	 */
	public UserLoginResponse login(String userName, String passWord) throws InvalidLoginException{
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = this.dao.findUserByName(userName);
			if (user != null && user.getPassword().equals(passWord)) {
				int sessionId = dao.createSession(user);
				response.setSessionId(sessionId);
				response.setUser(this.dtoAssembler.makeDTO(user));
				logger.info("Login erfolgreich.");
			} else {
				logger.info("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + userName);
				throw new InvalidLoginException(
						"Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + userName);
			}
		} catch (LiveTickerException e) {
			// Eine Exception wird dem Webservice-Client über einen Errorcode
			// mitgeteilt:
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Methode zum ausloggen eines eingeloggten Users
	 * 
	 * @param sessionId
	 * @return Response
	 */
	public ReturncodeResponse logout(int sessionId) {
		dao.closeSession(sessionId);
		ReturncodeResponse response = new ReturncodeResponse();
		logger.info("Logout successful.");
		return response;
	}

	/**
	 * Methode zum Registrieren eines neuen Users
	 * 
	 * @param userName
	 * @param email
	 * @param password
	 * @return Response auf den neuen User mit den eingebeben Daten
	 * @throws LiveTickerException
	 */
	public UserLoginResponse registerNewUser(String userName, String email, String password) throws LiveTickerException{
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = dao.createUser(userName, email, password);
			if (user != null) {
				// create new session for the just created customer:
				int sessionId = dao.createSession(user);
				logger.info("Registrierung von \"" + userName + "\" erfolgreich. " + "Erzeugte Session=" + sessionId);
				response.setSessionId(sessionId);
			} else {
				logger.info(
						"Registrieren fehlgeschlagen, da der Username bereits existiert." + " username=" + userName);
				throw new LiveTickerException(30,
						"Registrieren fehlgeschlagen, da der Username " + "bereits existiert. username=" + userName);
			}
		} catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

/**
 * Methode zum erstellen eines neuen Spiels
 * @param sessionId - des zurzeit angemeldeten Benutzers
 * @param team1 Mannschaft 1
 * @param team2 Mannschaft 2
 * @param aDate Datum des Spielbeginn
 * @return einen repsonse code ob das spiel angelegt wurde.
 * @throws LiveTickerException
 */
	public AddNewGameResponse createNewGame(int sessionId, Team team1, Team team2, Date aDate) throws LiveTickerException{
		AddNewGameResponse response = new AddNewGameResponse();

		try {
			LiveTickerSession s1 = getSession(sessionId);
			Game g1 = dao.createGame(team1, team2, aDate);
			if (g1 != null) {
				response.setGameid(g1.getId());
				response.setGame(this.dtoAssembler.makeDTO(g1));
				String message = s1.getUser().getUserName() + " hat das Spiel (ID:" + g1.getId() + ") erstellt!";
				logger.info(message);
				outputRequester.LiveTickerNotification(message);
			} else {
				logger.info("Spiel konnte nicht erstellt werden.");
				throw new LiveTickerException(30, "Erstellung des Spiels fehlgeschlagen");
			}

		} catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Neues Event wird erstellt
	 * 
	 * @param sessionId
	 *            id des users
	 * @param gameId
	 * @param art
	 *            des event wie gelbe/rote karte oder spielerwechsel
	 * @param team,
	 *            welches team ein event ausgeführt hat... später wird noch als
	 *            eigene entität
	 * @param reason,
	 *            evtl beschreibung zum event
	 * @param min:
	 *            in welcher spielminute ist dieses event eingetreten
	 * @return gibt eine Response auf das Event mit den erstellten Eingaben
	 * @throws LiveTickerException , wird geworfen wenn das Spiel nicht erstellt werden konnte
	 */
	public AddNewEventResponse createNewEvent(int sessionId, int gameId, int art, int team, String reason, int min) throws LiveTickerException{
		AddNewEventResponse response = new AddNewEventResponse();
		try {
			LiveTickerSession s1 = getSession(sessionId);
			Event e1 = dao.createEvent(gameId, art, team, reason, min);
			if(e1!= null){
				response.setEventid(e1.getId());
				response.setEvent(this.dtoAssembler.makeDTO(e1));
				String message = s1.getUser().getUserName() + " hat das Event " + s1.getId() + " erstellt!";
				logger.info(message);
				outputRequester.LiveTickerNotification(message);
			}
			else{
				logger.info("Event konnte nicht erstellt werden.");
				throw new LiveTickerException(30, "Erstellung des Events fehlgeschlagen");
			}
			
		} catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Methode um einen neuen Favoriten hinzufuegen
	 * @param sessionId
	 * @param newTeamId
	 * @return Gibt bei erfolgreicher durchfuehrung ein "OK" zurueck
	 * @throws LiveTickerException - Favorit konnte nicht erstellt werden
	 */
	public ReturncodeResponse addNewFavorite(int sessionId, int newTeamId) throws LiveTickerException {
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			LiveTickerSession s1 = getSession(sessionId);
			User u1 = s1.getUser();
			Team t1 = dao.findTeamByID(newTeamId);
			if (t1 != null) {
				dao.addFavorites(u1, t1);
				String message = u1.getUserName() + " hat die Mannschaft " + t1.getTeamName()
						+ " als Favorit hinzugefuegt!";
				logger.info(message);
				outputRequester.LiveTickerNotification(message);
			} else {
				logger.info("Favorit konnte nicht erstellt werden.Nicht angemeldet");
				throw new LiveTickerException(30, "Erstellung des Favorits fehlgeschlagen.");
			}

		} catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Methode um einen Favoriten wieder zu löschen
	 * @param sessionId
	 * @param newTeamId
	 * @return Gibt bei erfolgreicher durchfuehrung ein "OK" zurueck
	 * @throws LiveTickerException , wenn das Team nicht als Favorit vom User gefunden wurde. Um es zu loeschen
	 */
	public ReturncodeResponse deleteNewFavorite(int sessionId, int newTeamId) throws LiveTickerException {
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			LiveTickerSession s1 = getSession(sessionId);
			User u1 = s1.getUser();
			dao.deleteFavorites(u1, newTeamId);
			Team t1 = dao.findTeamByID(newTeamId);
			if(t1!= null){			
				logger.info("Favorit konnte nicht geleoscht werden.");
				throw new LiveTickerException(30, "Loeschen des Favorits fehlgeschlagen.");
			}
			else{
				@SuppressWarnings("null")
				String message = u1.getUserName() + " hat die Mannschaft " + t1.getTeamName() + " als Favorit geloescht!";
				logger.info(message);
				outputRequester.LiveTickerNotification(message);
			}
		} catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	/**
	 * Methode um die Favoriten Teams des Users anzuzeigen
	 * @param sessionId
	 * @return response - eine Liste der Teams
	 * @throws LiveTickerException - Favorit konnten nicht gefunden werden
	 */
	public AddNewFavoriteResponse displayMyFavorite(int sessionId) throws LiveTickerException{
		AddNewFavoriteResponse response = new AddNewFavoriteResponse();
		try {
			LiveTickerSession s1 = getSession(sessionId);
			User user = s1.getUser();
			List<User> favoList = dao.displayFavorites(user);
			if(!(favoList.isEmpty())){
				response.setFavoriteList(this.dtoAssembler.makeDTO(favoList));
				String message = user.getUserName() + "'s Favoriten";
				logger.info(message);
				outputRequester.LiveTickerNotification(message);
			}
			else{
				logger.info("Favorit konnten nicht gefunden werden.");
				throw new LiveTickerException(30, "Favoriten abrufen fehlgeschlagen.Keine Favoriten vorhanden");
			}
		
		} catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	/**
	 * Methode um alle Teams der Liga darzustellen
	 * @param Liga wird später noch implementiert, mehrere teams gehören zu einer liga. 
	 * es sollen später noch weitere ligen verfügbar sein
	 * @return response mit der Liste der Teams
	 * @throws LiveTickerException - Teams konnten nicht gefunden werden.
	 */
	public ReturncodeResponse displayLiga(String liga) throws LiveTickerException{
		ReturncodeResponse response = new ReturncodeResponse();
		try{
			Team t1 = dao.displayLiga(liga);
			if(t1!=null){
				String message = "'s Favoriten";
				logger.info(message);
				outputRequester.LiveTickerNotification(message);
			}
			else{
				logger.info("Teams konnten nicht gefunden werden.");
				throw new LiveTickerException(30, "Teams abrufen fehlgeschlagen.Teams nicht vorhanden");
			}
		}
		catch(LiveTickerException e){
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
		
	}
}
