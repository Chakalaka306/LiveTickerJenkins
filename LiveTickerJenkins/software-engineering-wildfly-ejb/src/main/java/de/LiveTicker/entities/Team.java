package de.LiveTicker.entities;
/**
 * @author Dominik Teipel
 */
import java.io.Serializable;


/**
 * @author Dominik Teipel
 */
import javax.persistence.*;

@Entity
public class Team implements Serializable {
	
	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int id;
	@Column(nullable=false)
	private String teamName;
	
	
	public Team(){
		
	}
	public int getId(){
		return id;
	}
	
	public Team(String teamName){
		this.teamName= teamName;
	}
	public void setTeamName(String teamName){
		this.teamName=teamName;
	}
	public String getTeamName(){
		return this.teamName;
	}
	
}
