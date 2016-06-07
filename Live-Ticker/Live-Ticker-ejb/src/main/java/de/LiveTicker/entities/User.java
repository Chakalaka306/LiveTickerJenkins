package de.LiveTicker.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	@Column(nullable=false)
	private String userName;
	@Column(unique=true, nullable=false)
	private String email;
	private String password;
	
	private static int lastID = 0;
	
	public User() {
		
	}

	public User(String userName, String email, String password) {
		
		this.id = lastID++;
		this.userName = userName;
		this.setPassword(password);
		this.email = email;
	}
	public String getUserName(){
		return this.userName;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
