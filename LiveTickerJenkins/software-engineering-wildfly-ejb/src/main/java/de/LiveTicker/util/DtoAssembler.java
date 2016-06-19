package de.LiveTicker.util;

import java.util.List;

import javax.ejb.Stateless;


import de.LiveTicker.dto.*;
import de.LiveTicker.entities.*;


@Stateless
public class DtoAssembler {

	public UserTO makeDTO(User user) {
		UserTO dto = new UserTO();
		  dto.setPassword(user.getPassword());
		  dto.setUserName(user.getUserName());
		  return dto;
	  }
	public EventTO makeDTO(Event event){
		EventTO dto= new EventTO();
		dto.setArt(event.getArt());
		dto.setMin(event.getMin());
		dto.setTeam(event.getTeam());
		dto.setReason(event.getReason());
		dto.setGameid(event.getGameID());
		
		return dto;	
	}
	public GameTO makeDTO(Game game){
		GameTO dto= new GameTO();
		
		 dto.setAnstoß(game.getAnstoß());
		 dto.setTeam1(game.getTeam1());
		 dto.setTeam2(game.getTeam2());	 
		
		return dto;	
	}
	@SuppressWarnings("unchecked")
	public List<FavoriteTO> makeDTO(List<User> favoList) {
		FavoriteTO dto= new FavoriteTO();
		for (int i =0;i < favoList.size(); i++){
			dto.setTeam(favoList.toString());
		}		
		return (List<FavoriteTO>) dto;
	}	
}
