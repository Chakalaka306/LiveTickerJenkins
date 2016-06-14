package de.LiveTicker.dto;

public class AddnewGameResponse extends ReturncodeResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameTO game;
	private int gameid;
	
	public AddnewGameResponse(){
		
	}

	public GameTO getGame() {
		return game;
	}

	public void setGame(GameTO game) {
		this.game = game;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	
	
}
