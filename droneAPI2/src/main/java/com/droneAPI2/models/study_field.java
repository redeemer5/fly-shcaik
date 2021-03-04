package com.droneAPI2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studyfield")
public class study_field {
	
	// attributes
	@Id
	@GeneratedValue
	private int s_id;
	private String study_field;
	
	// getters and setters
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getStudy_field() {
		return study_field;
	}
	public void setStudy_field(String study_field) {
		this.study_field = study_field;
	}
	
	// constructor
	public study_field(int s_id, String study_field) {
		this.s_id = s_id;
		this.study_field = study_field;
	}
	
	public study_field() {
		
	}
	
	

	
}
