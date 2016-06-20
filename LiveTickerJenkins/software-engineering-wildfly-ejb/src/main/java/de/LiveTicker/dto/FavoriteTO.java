package de.LiveTicker.dto;
/**
 * 
 * @author Dominik Teipel
 *
 */
public class FavoriteTO extends DataTransferObject{

	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String team;
	/**
	 * leere Konstruktor
	 */
	public FavoriteTO(){
		
	}
	/**
	 * Konstruktor
	 * @param user welcher user hat...
	 * @param team welche teams als favorit
	 */
	public FavoriteTO(String user, String team){
		this.setUser(user);
		this.setTeam(team);
	}
	/**
	 * Get Methode
	 * @return
	 */
	public String getUser() {
		return user;
	}
	/**
	 * Set Methode
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * Get Methode
	 * @return
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * Set Methode
	 * @param team
	 */
	public void setTeam(String team) {
		this.team = team;
	}
}
