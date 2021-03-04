package com.droneAPI2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class books {
	
	// attributes
	@Id
	@GeneratedValue
	private int b_id;
	private String booktitle;
	private String author;
	private String field;
	private String version;
	private int quantity;
	private String description;
	private String library;
	private int count;
	
	// getters and setters
	
	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	// constructor
	public books(int b_id, String booktitle, String author, String field, String version, int quantity,
			String description, String library, int count) {
		this.b_id = b_id;
		this.booktitle = booktitle;
		this.author = author;
		this.field = field;
		this.version = version;
		this.quantity = quantity;
		this.description = description;
		this.library = library;
		this.count = count;
	}
	

	public books() {

	}






		
}
