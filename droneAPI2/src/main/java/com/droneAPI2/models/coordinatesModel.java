package com.droneAPI2.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coordinates")
public class coordinatesModel {
	
	// attributes
	
	@Id
	private int cid;
	private String longitude;
	private String latitide;
	
	// getters and setters
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitide() {
		return latitide;
	}
	public void setLatitide(String latitide) {
		this.latitide = latitide;
	}
	
	// constructor
	public coordinatesModel(int cid, String longitude, String latitide) {
		this.cid = cid;
		this.longitude = longitude;
		this.latitide = latitide;
	}
	
	// default constructor
	public coordinatesModel() {

	}
}
