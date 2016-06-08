package de.LiveTicker.dto;

public class UserTO extends DataTransferObject{
	
private static final long serialVersionUID = -1044563636105941958L;
	
	private int id;
	private String userName;
	private String password;
	private String email;
	
	public UserTO() {
	}
	
	public UserTO(int id, String userName,String email, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
