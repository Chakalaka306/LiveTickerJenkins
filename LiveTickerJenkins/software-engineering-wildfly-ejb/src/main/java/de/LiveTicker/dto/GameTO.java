package de.LiveTicker.dto;

import java.util.Date;

public class GameTO extends DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Team1;
	private String Team2;
	private Date anstoß;
	private int tore1;
	private int tore2;
	
	public GameTO() {
		
	}
	public GameTO(String team1, String team2, Date anstoß) {
		this.setTeam1(team1);
		this.setTeam2(team2);
		this.setAnstoß(anstoß);
		this.setTore1(0);
		this.setTore2(0);
	}
	public String getTeam1() {
		return Team1;
	}
	public void setTeam1(String team1) {
		Team1 = team1;
	}
	public String getTeam2() {
		return Team2;
	}
	public void setTeam2(String team2) {
		Team2 = team2;
	}
	public Date getAnstoß() {
		return anstoß;
	}
	public void setAnstoß(Date anstoß) {
		this.anstoß = anstoß;
	}
	public int getTore1() {
		return tore1;
	}
	public void setTore1(int tore1) {
		this.tore1 = tore1;
	}
	public int getTore2() {
		return tore2;
	}
	public void setTore2(int tore2) {
		this.tore2 = tore2;
	}
}