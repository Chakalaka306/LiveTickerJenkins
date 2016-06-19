package de.LiveTicker.util;

import javax.ejb.Stateless;
import de.LiveTicker.dto.UserTO;
import de.LiveTicker.entities.User;

@Stateless
public class DtoAssembler {

	public UserTO makeDTO(User user) {
		UserTO dto = new UserTO();
		  dto.setPassword(user.getPassword());
		  dto.setUserName(user.getUserName());
		  return dto;
	  }
}
