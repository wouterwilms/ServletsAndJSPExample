package be.intecbrussel.entities;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idUser;
	
	private String userNaam;
	
	private String PwdHash;
	
	public User() {
		
		this(0,null,null);
		
	}
	
	public User (int idUser, String userNaam, String pwdMD5) {
		
		this.idUser = idUser;
		
		this.userNaam = userNaam;
		
		this.PwdHash = pwdMD5;
		
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserNaam() {
		return userNaam;
	}

	public void setUserNaam(String userNaam) {
		this.userNaam = userNaam;
	}

	public String getPwdHash() {
		return PwdHash;
	}

	public void setPwdHash(String PwdHash) {
		this.PwdHash = PwdHash;
	}
	
}
