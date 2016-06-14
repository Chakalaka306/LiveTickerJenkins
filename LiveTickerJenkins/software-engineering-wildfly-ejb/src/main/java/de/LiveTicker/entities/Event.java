package de.LiveTicker.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	
	public Event (int gameid,int art, int team,String reason, int min){
		this.gameid=gameid;
		this.art=art;
		this.team=team;
		this.reason=reason;
		this.min=min;
	}
	
	public int getId() {
		return id;
	}
	/*
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
		case 4: reason="Spielerwechsel";
			break;
		// tor
		case 5: reason="Tor";
			break;
		// abpfiff
		case 6: reason="Spiel ist beendet.";
			break;
		
		}
	}*/
}
