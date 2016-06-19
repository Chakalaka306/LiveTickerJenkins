package de.LiveTicker.dto;

public class FavoriteTO extends DataTransferObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String team;
	
	public FavoriteTO(){
		
	}
	public FavoriteTO(String user, String team){
		this.setUser(user);
		this.setTeam(team);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
