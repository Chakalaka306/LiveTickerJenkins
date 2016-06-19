package de.LiveTicker.dto;

/**
 * 
 * @author Dominik Teipel
 *
 */

public class AddNewGameResponse extends ReturncodeResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attribute
	 */
	private GameTO game;
	private int gameid;
	/**
	 * leerer Konstruktor
	 */
	public AddNewGameResponse(){
		
	}
	/**
	 * Methode zum setzen des Spiels
	 * @return Objekt des Spiels
	 */
	public GameTO getGame() {
		return game;
	}
	/**
	 * Methode zum Setzen des Spiels
	 * @param game
	 */
	public void setGame(GameTO game) {
		this.game = game;
	}
	/**
	 * Methode liefer die ID des Spiels zurück
	 * @return Die Spiel ID
	 */
	public int getGameid() {
		return gameid;
	}
	/**
	 * Methode zum setzen des Spiels
	 * @param gameid
	 */
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	
	
}
