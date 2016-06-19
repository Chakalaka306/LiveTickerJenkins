package de.LiveTicker.dto;

/**
 * 
 * @author Dominik Teipel
 *
 */

public class EventTO extends DataTransferObject {

	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int art;
	private int team;
	private String reason;
	private int min;
	private int gameid;
	
	/**
	 * leerer Konstruktor
	 */
	public EventTO(){
	
	}
	/**
	 * Konstruktor
	 * @param gameid
	 * @param art
	 * @param team
	 * @param reason
	 * @param min
	 */
	public EventTO(int gameid,int art, int team,String reason, int min){
		super();
		this.setGameid(gameid);
		this.setArt(art);
		this.setTeam(team);
		this.setReason(reason);
		this.setMin(min);
		
	}
	/**
	 * Methode gibt die ID zurück
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Methode zum setzen der ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get-Methode 
	 * @return art
	 */
	public int getArt() {
		return art;
	}
	/**
	 * Set-Methode
	 * @param art
	 */
	public void setArt(int art) {
		this.art = art;
	}
	/**
	 * Get-Methode
	 * @return team
	 */
	public int getTeam() {
		return team;
	}
	/**
	 * Set-Methode
	 * @param team
	 */
	public void setTeam(int team) {
		this.team = team;
	}
	/**
	 * Get-Methode
	 * @return
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * Set-Methode
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * Get-Methode
	 * @return Spielminute
	 */
	public int getMin() {
		return min;
	}
	/**
	 * Set-Methode
	 * @param min
	 */
	public void setMin(int min) {
		this.min = min;
	}
	/**
	 * Get-Methode
	 * @return gameId
	 */
	public int getGameid() {
		return gameid;
	}
	/**
	 * Set-Methode
	 * @param gameid
	 */
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
}
