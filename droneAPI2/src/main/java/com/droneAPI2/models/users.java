package com.droneAPI2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class users {

	// attributes
	@Id
	@GeneratedValue
	private int uid;
	private String username;
	private String usersurname;
	private String email;
	private String usercell;
	private String password;
	
	// getters and setters
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsersurname() {
		return usersurname;
	}

	public void setUsersurname(String usersurname) {
		this.usersurname = usersurname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsercell() {
		return usercell;
	}

	public void setUsercell(String usercell) {
		this.usercell = usercell;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// constructor
	
	public users(int uid, String username, String usersurname, String email, String usercell, String password) {
		this.uid = uid;
		this.username = username;
		this.usersurname = usersurname;
		this.email = email;
		this.usercell = usercell;
		this.password = password;
	}
	
	public users() {

	}





	

		
	
}
