package de.LiveTicker.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Dominik Teipel
 * 
 */
@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute
	 */
	
	@Id
	private int id;
	@Column(nullable=false)
	private int art;
	@Column(nullable=false)
	private int team;
	@Column(nullable=true)
	private String reason;
	@Column(nullable=false)
	private int min;
	@Column(nullable=false)
	private int gameid;
	/**
	 * Leere Konstruktor
	 */
	public Event(){
		
	}
	/**
	 * Konstruktor
	 * Ein event gehört immer zu einem Spiel
	 * @param gameid 
	 * @param art
	 * @param team
	 * @param reason
	 * @param min
	 */
	
	public Event (int gameid,int art, int team,String reason, int min){
		this.art=art;
		this.team=team;
		this.reason=reason;
		this.min=min;
		this.gameid=gameid;
	}
	/**
	 * Gibt die ID des Events züruck
	 * @return id
	 */
	public int getId(){
		return id;
	}
	public int getArt(){
		return art;
	}
	public void setArt(int art){
		this.art=art;
	}
	public int getTeam(){
		return team;
	}
	public void setTeam(int team){
		this.team=team;
	}
	public String getReason(){
		return reason;	
	}
	public void setReason(String reason){
		this.reason=reason;
	}
	public int getMin(){
		return min;	
	}
	public void setMin(int min){
		this.min=min;
	}
	public int getGameID(){
		return gameid;
	}
	public void setGameID(int gameid){
		this.gameid=gameid;
	}
	/**
	public void whatArt(int art){
		
		switch(art){
		// gelbe karte
		case 1: reason="gelbe karte";
			break;
		// rote karte
		case 2: reason="rote karte";
			break;
		// freistoß
		case 3: reason="freistoß";
			break;
		// spielerwechsel
		case 4: reason="Tor";
			break;
		// tor
		case 5: reason="Spielerwechsel";
			break;
		//chance
		case 6: reason="Chance";
		// abpfiff
		case 7: reason="Spiel ist beendet.";
			break;
		
		}
	}*/
}
