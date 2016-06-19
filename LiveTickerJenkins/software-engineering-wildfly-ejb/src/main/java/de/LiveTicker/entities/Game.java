package de.LiveTicker.entities;
/**
 * 
 * @author Dominik Teipel
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game implements Serializable{

	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable=false)
	private String Team1;
	@Column(unique=true, nullable=false)
	private String Team2;
	@Column(nullable=false)
	private Date anstoß;
	@Column(nullable=true)
	private int tore1;
	@Column(nullable=true)
	private int tore2;
		/**
		 * Leerer Konstruktor
		 */
	public Game (){
		
	}
	/**
	 * Konstruktor
	 * @param team1
	 * @param team2
	 * @param anstoß - Datum des anstoßes
	 */
	public Game(String team1, String team2, Date anstoß){
		this.Team1= team1;
		this.Team2= team2;
		this.anstoß= anstoß;
		this.tore1= 0;
		this.tore2= 0;
		
	}
	/**
	 * Gibt ID des Spiels zurück
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Gibt Teamname der Mannschaft zurueck
	 * @return
	 */
	public String getTeam1(){
		return this.Team1;
	}
	/**
	 * Setzt Teamnamen
	 * @param team1
	 */
	public void setTeam1(String team1){
		this.Team1=team1;
	}
	/**
	 * Gibt Teamname der Mannschaft zurueck
	 * @return
	 */
	public String getTeam2(){
		return this.Team2;
	}
	/**
	 * Setzt Teamnamen
	 * @param team2
	 */
	public void setTeam2(String team2){
		this.Team1=team2;
	}
	/**
	 * Gibt Datum / Uhrzeit des Spielbeginns
	 * @return
	 */
	public Date getAnstoß(){
		return this.anstoß;
	}
	/**
	 * Setzt den Spielbeginn
	 * @param anstoß
	 */
	public void setAnstoß(Date anstoß){
		this.anstoß= anstoß;
	}
	/**
	 * Erhöht die Tore der jeweiligen Mannschaft 
	 * @param team
	 */
	public void increaseTor(String team){
		if(team.equals(Team1)){
			tore1++;
		}
		else{
			tore2++;
		}
	}
	/**
	 * Verringert die Tore der jeweiligen Mannschaft
	 * @param team
	 */
	public void decreaseTor(String team){
		if(team.equals(Team1)){
			if(tore1>0){
				tore1--;
			}
		}
		else{
			if(tore2>0){
				tore2--;
			}
			
		}
	}
	
}
