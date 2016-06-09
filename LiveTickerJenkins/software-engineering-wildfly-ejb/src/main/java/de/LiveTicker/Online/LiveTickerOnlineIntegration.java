package de.LiveTicker.Online;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.LiveTicker.dao.*;
import de.LiveTicker.dto.ReturncodeResponse;
import de.LiveTicker.dto.UserLoginResponse;
import de.LiveTicker.entities.*;
import de.LiveTicker.util.DtoAssembler;



@WebService
@WebContext(contextRoot="/software-engineering-wildfly")
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
	 * @param sessionId
	 * @return
	 * @throws NoSessionException
	 */
	@SuppressWarnings("unused")
	private LiveTickerSession getSession(int sessionId) throws NoSessionException {
		LiveTickerSession session = dao.findSessionById(sessionId);
		if (session==null)
			throw new NoSessionException("Bitte zunächst ein Login durchführen.");
		else
			return session;
	}
	public UserLoginResponse login(String username, String password) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = this.dao.findUserByName(username);		
			if (user != null && user.getPassword().equals(password)) {
				int sessionId = dao.createSession(user);
				response.setSessionId(sessionId);
				response.setUser(this.dtoAssembler.makeDTO(user));
				logger.info("Login erfolgreich.");				
			}
			else {
				logger.info("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username=" + username);
				throw new InvalidLoginException("Login fehlgeschlagen, da Kunde unbekannt oder Passwort falsch. username="+username);
			}
		}
		catch (LiveTickerException e) {
			//Eine Exception wird dem Webservice-Client über einen Errorcode mitgeteilt:
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	public ReturncodeResponse logout(int sessionId) {
		dao.closeSession(sessionId);
		ReturncodeResponse response = new ReturncodeResponse();
		logger.info("Logout successful.");
		return response;
	}
	
	public UserLoginResponse registerNewUser(String userName,String email, String password) {
		UserLoginResponse response = new UserLoginResponse();
		try {
			User user = dao.createUser(userName,email,password);		
			if (user != null) {
				//create new session for the just created customer:
				int sessionId = dao.createSession(user);
				logger.info("Registrierung von \"" + userName + "\" erfolgreich. "
						  + "Erzeugte Session=" + sessionId);
				response.setSessionId(sessionId);				
			}
			else {
				logger.info("Registrieren fehlgeschlagen, da der Username bereits existiert."
						  + " username=" + userName);
				throw new LiveTickerException(30, "Registrieren fehlgeschlagen, da der Username "
						  + "bereits existiert. username=" + userName);
			}
		}
		catch (LiveTickerException e) {
			response.setReturnCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		}		
		return response;		
	}
}
