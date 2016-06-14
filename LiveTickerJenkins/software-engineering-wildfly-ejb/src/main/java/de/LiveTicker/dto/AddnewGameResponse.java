package de.LiveTicker.dto;

public class AddnewGameResponse extends ReturncodeResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GameTO game;
	
	public AddnewGameResponse(){
		
	}

	public GameTO getGame() {
		return game;
	}

	public void setGame(GameTO game) {
		this.game = game;
	}
	
	
}
