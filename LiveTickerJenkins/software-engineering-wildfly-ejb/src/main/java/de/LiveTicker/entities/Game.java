package de.LiveTicker.entities;

import java.io.Serializable;

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
	
}
