package de.LiveTicker.dto;
/**
 * @author Dominik Teipel
 */
import java.util.List;

public class AddNewFavoriteResponse extends ReturncodeResponse{

	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 1L;

	private List<FavoriteTO> favoriteList;
	/**
	 * 
	 * @return gibt die Favoriten Liste zurück
	 */
	public List<FavoriteTO> getFavoriteList() {
		return favoriteList;
	}
	/**
	 * Methode zum setzen der Favoriten Liste
	 * @param favoriteList
	 */
	public void setFavoriteList(List<FavoriteTO> favoriteList) {
		this.favoriteList = favoriteList;
	}
}
