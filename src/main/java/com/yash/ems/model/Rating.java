package com.yash.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int ratingId;
	private String ratingDesc;
	private String ratingBriefDesc;
	public Rating() {
		
	}
	
	public Rating(int ratingId, String ratingDesc, String ratingBriefDesc) {
	
		this.ratingId = ratingId;
		this.ratingDesc = ratingDesc;
		this.ratingBriefDesc = ratingBriefDesc;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingDesc() {
		return ratingDesc;
	}

	public void setRatingDesc(String ratingDesc) {
		this.ratingDesc = ratingDesc;
	}

	public String getRatingBriefDesc() {
		return ratingBriefDesc;
	}

	public void setRatingBriefDesc(String ratingBriefDesc) {
		this.ratingBriefDesc = ratingBriefDesc;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", ratingDesc=" + ratingDesc + ", ratingBriefDesc=" + ratingBriefDesc
				+ "]";
	}
	
	
	

}
