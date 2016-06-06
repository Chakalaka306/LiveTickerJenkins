package de.LiveTicker.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Account {
	
	@Id
	private int id;
	@Column(nullable=false)
	private String userName;
	@Column(unique=true, nullable=false)
	private String email;
	private String password;
	
	private static int lastID = 0;
	
	public Account() {
		
	}

	public Account(String userName, String email, String password) {
		
		this.id = lastID++;
		this.userName = userName;
		this.setPassword(password);
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
