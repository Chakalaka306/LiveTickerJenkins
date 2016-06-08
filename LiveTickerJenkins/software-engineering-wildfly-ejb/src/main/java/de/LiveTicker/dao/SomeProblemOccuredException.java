package de.LiveTicker.dao;


import javax.ejb.ApplicationException;
import de.LiveTicker.Online.LiveTickerException;

@ApplicationException(rollback=false) 
public class SomeProblemOccuredException extends LiveTickerException {

	private static final long serialVersionUID = 1L;

	public SomeProblemOccuredException(int errorCode, String message) {
		super(errorCode, message);
	}
}
