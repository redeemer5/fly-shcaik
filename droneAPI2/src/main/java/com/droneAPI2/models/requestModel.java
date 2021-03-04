package com.droneAPI2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class requestModel {
	
	// attributes
	@Id
	@GeneratedValue
	private int o_id;
	private int ordernumber;
	private String library;
	private String date;
	private String item;
	private String name;
	private String surname;
	private String email;
	private String contact;
	private String droplocation;
	private int amountdue;
	
	// getters and setters
	
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public int getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getLibrary() {
		return library;
	}
	public void setLibrary(String library) {
		this.library = library;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDroplocation() {
		return droplocation;
	}
	public void setDroplocation(String droplocation) {
		this.droplocation = droplocation;
	}
	public int getAmountdue() {
		return amountdue;
	}
	public void setAmountdue(int amountdue) {
		this.amountdue = amountdue;
	}
	
	// constructor
	public requestModel(int o_id, int ordernumber, String library, String date, String item, String name,
			String surname, String email, String contact, String droplocation, int amountdue) {
		this.o_id = o_id;
		this.ordernumber = ordernumber;
		this.library = library;
		this.date = date;
		this.item = item;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.contact = contact;
		this.droplocation = droplocation;
		this.amountdue = amountdue;
	}
	
	public requestModel() {

	}
	
	
	
	


	
	
	
	

}
