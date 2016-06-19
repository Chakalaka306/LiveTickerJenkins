package de.LiveTicker.dto;
/**
 * 
 * @author Dominik Teipel
 *
 */
public class UserTO extends DataTransferObject{
	/**
	 * Attribute
	 */
private static final long serialVersionUID = -1044563636105941958L;
	
	private int id;
	private String userName;
	private String password;
	private String email;
	/**
	 * leerer Konstruktor
	 */
	public UserTO() {
	}
	/**
	 * Constructor
	 * @param id
	 * @param userName
	 * @param email
	 * @param password
	 */
	public UserTO(int id, String userName,String email, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	/**
	 * Get-Methode
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Set-Methode
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Get-Methode
	 * @return username
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Set-Methode
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * Get-Methode
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Set-Methode
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Get-Methode
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Set-Methode
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
