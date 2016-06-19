package de.LiveTicker.dto;
/**
 * 
 * @author Dominik Teipel
 *
 */
public class UserLoginResponse extends ReturncodeResponse{
/**
 * Attribute
 */
	private static final long serialVersionUID = -3173158310918408228L;
	
	private int sessionId;
	private UserTO user;
	/**
	 * Get-Methode
	 * @return
	 */
	public int getSessionId() {
		return sessionId;
	}
	/**
	 * Set-Methode
	 * @param sessionId
	 */
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * Get-Methode
	 * @return User
	 */
	public UserTO getUser() {
		return this.user;
	}
	/**
	 * Set-Methode
	 * @param user
	 */
	public void setUser(UserTO user) {
		this.user = user;
	}
}




	