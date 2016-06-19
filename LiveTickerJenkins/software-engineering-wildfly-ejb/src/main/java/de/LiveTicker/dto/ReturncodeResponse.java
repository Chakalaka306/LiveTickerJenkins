package de.LiveTicker.dto;
/**
 * 
 * @author Dominik Teipel
 *
 */
public class ReturncodeResponse extends DataTransferObject {
	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 3397348747136795401L;
	private static final int CODE_OK = 0;
	
	private int returnCode;
	private String message;
	/**
	 * Konstruktor
	 */
	public ReturncodeResponse() {
		this.returnCode = CODE_OK;
	}
	/**
	 * Get-Methode
	 * @return gibt einen Code zurück, ob andere Methoden fehlerfrei ausgefuehrt wurden.
	 */
	public int getReturnCode() {
		return returnCode;
	}
	/**
	 * Methode zum Setzen des ReturnCodes
	 * @param returnCode
	 */
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * Get-Methode
	 * @return nachricht
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Methode zum Setzen der Nachricht
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
