package de.LiveTicker.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game implements Serializable{

	/**
	 * 
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
		
	public Game (){
		
	}
	public Game(String team1, String team2, Date anstoß){
		this.Team1= team1;
		this.Team2= team2;
		this.anstoß= anstoß;
		this.tore1= 0;
		this.tore2= 0;
		
	}
	public int getId() {
		return id;
	}
	public void increaseTor(String team){
		if(team.equals(Team1)){
			tore1++;
		}
		else{
			tore2++;
		}
	}
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
