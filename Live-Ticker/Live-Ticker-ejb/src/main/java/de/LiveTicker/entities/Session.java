package de.LiveTicker.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Session {
	
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private Account user;
	private Date creationTime;

	public Session(Account user) {
		this.user = user;
		this.setCreationTime(new Date());
	}

	public int getId() {
		return id;
	}
	public Account getUser() {
		return user;
	}
	public void setUser(Account user) {
		this.user = user;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
