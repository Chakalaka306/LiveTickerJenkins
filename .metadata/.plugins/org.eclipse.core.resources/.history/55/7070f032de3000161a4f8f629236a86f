package de.LiveTicker.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class LiveTickerSession {
	
	@Id @GeneratedValue
	private int id;
	@ManyToOne
	private User user;
	private Date creationTime;

	public LiveTickerSession(){
		
	}
	public LiveTickerSession(User user) {
		this.user = user;
		this.setCreationTime(new Date());
	}

	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
