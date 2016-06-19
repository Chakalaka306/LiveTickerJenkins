package de.LiveTicker.dto;

import java.util.Date;
/**
 * 
 * @author Dominik Teipel
 *
 */
public class GameTO extends DataTransferObject {

	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	private String Team1;
	private String Team2;
	private Date anstoß;
	private int tore1;
	private int tore2;
	/**
	 * leerer Konstruktor
	 */
	public GameTO() {
		
	}
	/**
	 * Konstrukor 
	 * @param team1
	 * @param team2
	 * @param anstoß - Date- 
	 */
	public GameTO(String team1, String team2, Date anstoß) {
		this.setTeam1(team1);
		this.setTeam2(team2);
		this.setAnstoß(anstoß);
		this.setTore1(0);
		this.setTore2(0);
	}
	/**
	 * Get-Methode
	 * @return team1
	 */
	public String getTeam1() {
		return Team1;
	}
	/**
	 * Set-Methode
	 * @param team1
	 */
	public void setTeam1(String team1) {
		Team1 = team1;
	}
	/**
	 * Get-Methode
	 * @return team1
	 */
	public String getTeam2() {
		return Team2;
	}
	/**
	 * Set-Methode
	 * @param team2
	 */
	public void setTeam2(String team2) {
		Team2 = team2;
	}
	/**
	 * Get-Methode
	 * @return uhrzeit des Antoßes
	 */
	public Date getAnstoß() {
		return anstoß;
	}
	/**
	 * Set-Methode
	 * @param anstoß
	 */
	public void setAnstoß(Date anstoß) {
		this.anstoß = anstoß;
	}
	/**
	 * Get-Methode
	 * @return tore von mannschaft 1
	 */
	public int getTore1() {
		return tore1;
	}
	/**
	 * Set-Methode
	 * @param tore1
	 */
	public void setTore1(int tore1) {
		this.tore1 = tore1;
	}
	/**
	 * Get-Methode
	 * @return tore2
	 */
	public int getTore2() {
		return tore2;
	}
	/**
	 * Set-Methode
	 * @param tore2
	 */
	public void setTore2(int tore2) {
		this.tore2 = tore2;
	}
}
