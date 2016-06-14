package de.LiveTicker.dto;

public class AddnewEventResponse extends ReturncodeResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EventTO event;
	
	public AddnewEventResponse(){
		
	}

	public EventTO getEvent() {
		return event;
	}

	public void setEvent(EventTO event) {
		this.event = event;
	}
	
	

}
