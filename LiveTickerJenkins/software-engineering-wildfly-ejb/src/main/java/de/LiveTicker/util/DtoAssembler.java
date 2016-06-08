package de.LiveTicker.util;

import de.LiveTicker.dto.UserTO;
import de.LiveTicker.entities.User;

public class DtoAssembler {

	public UserTO makeDTO(User user) {
		UserTO dto = new UserTO();
		  dto.setPassword(user.getPassword());
		  dto.setUserName(user.getUserName());
		  return dto;
	  }
}
