package com.droneAPI2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class library {
	
	// attributes
	@Id
	@GeneratedValue
	private int l_id;
	private String library;
	private String address;
	private String user_name;
	private String user_surname;
	private String user_cell;
	private String password;
	
	// getters and setters	
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_surname() {
		return user_surname;
	}
	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}
	public String getUser_cell() {
		return user_cell;
	}
	public void setUser_cell(String user_cell) {
		this.user_cell = user_cell;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// constructor 
	public library(int l_id, String library, String address, String user_name, String user_surname, String user_cell,
			String password) {
		this.l_id = l_id;
		this.library = library;
		this.address = address;
		this.user_name = user_name;
		this.user_surname = user_surname;
		this.user_cell = user_cell;
		this.password = password;
	}
	
	
	public library() {

	}
}
