package de.LiveTicker.entities;
/**
 * @author Dominik Teipel
 */
import java.io.Serializable;
import java.util.Map;

import javax.persistence.*;



@Entity
public class User implements Serializable{
	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="ID")
	private int id;
	@Column(nullable=false)
	private String userName;
	@Column(unique=true, nullable=false)
	private String email;
	private String password;
	/**
	 * User und Team ist eine M zu M beziehung, daher wird eine eingestaendige Tabelle erzeugt.
	 * Bei ID sind Primary Keys
	 */
	@ManyToMany
	@JoinTable(
			name="USER_FAVO",
			joinColumns=@JoinColumn(name="USER_ID",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="TEAM_ID", referencedColumnName="id"))
	private Map<Integer, Team> favorites;
	
	private static int lastID = 0;
	
	public User() {
		
	}

	public User(String userName, String email, String password) {
		
		this.id = lastID++;
		this.userName = userName;
		this.setPassword(password);
		this.email = email;
	}
	public int getID(){
		return this.id;
	}
	/**
	 * Methode zum hinzufuegen eines Favorisiertem Team
	 * @param newTeam
	 */
	public void addNewFavorite(Team newTeam){
		this.favorites.put(newTeam.getId(), newTeam);
	}
	/**
	 * Methode um einen Favoriten zu loeschen
	 * @param id
	 */
	public void deleteFavorite(int id) {
		this.favorites.remove(id);
		
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
