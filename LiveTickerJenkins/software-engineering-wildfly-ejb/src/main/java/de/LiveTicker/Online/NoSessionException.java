package de.LiveTicker.Online;
/**
 * 
 * @author Dominik Teipel
 *
 */
public class NoSessionException extends LiveTickerException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 10;

	public NoSessionException(String message) {
		super(CODE, message);
	}

}
