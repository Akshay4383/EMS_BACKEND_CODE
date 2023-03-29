package com.yash.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EvaluationTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int evId;
	private String name;
	private String designation;
	
	
	
	public EvaluationTeam() {
		
	}
	public EvaluationTeam(int evId, String name, String designation) {
	
		this.evId = evId;
		this.name = name;
		this.designation = designation;
	}
	public int getEvId() {
		return evId;
	}
	public void setEvId(int evId) {
		this.evId = evId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "EvaluationTeam [evId=" + evId + ", name=" + name + ", designation=" + designation + "]";
	}
	
	
	
	
	

}
