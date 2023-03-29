package com.yash.ems.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evaluation implements Serializable {

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int evaluationId;

	private String overallRating;
	private String overallComment;
	@Temporal(TemporalType.DATE)
	private Date evaluationDate;

	private String angular;

	private String coreJava;

	private String react;
	private String springBoot;
	private String mySQL;
	private String aws;

	private String clientName;
	private String evaluatedBy;


	

	public Evaluation() {

	}




	public Evaluation(int evaluationId, String overallRating, String overallComment, Date evaluationDate,
			String angular, String coreJava, String react, String springBoot, String mySQL, String aws,
			String clientName, String evaluatedBy) {
		super();
		this.evaluationId = evaluationId;
		this.overallRating = overallRating;
		this.overallComment = overallComment;
		this.evaluationDate = evaluationDate;
		this.angular = angular;
		this.coreJava = coreJava;
		this.react = react;
		this.springBoot = springBoot;
		this.mySQL = mySQL;
		this.aws = aws;
		this.clientName = clientName;
		this.evaluatedBy = evaluatedBy;
	}




	public int getEvaluationId() {
		return evaluationId;
	}




	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}




	public String getOverallRating() {
		return overallRating;
	}




	public void setOverallRating(String overallRating) {
		this.overallRating = overallRating;
	}




	public String getOverallComment() {
		return overallComment;
	}




	public void setOverallComment(String overallComment) {
		this.overallComment = overallComment;
	}




	public Date getEvaluationDate() {
		return evaluationDate;
	}




	public void setEvaluationDate(Date evaluationDate) {
		this.evaluationDate = evaluationDate;
	}




	public String getAngular() {
		return angular;
	}




	public void setAngular(String angular) {
		this.angular = angular;
	}




	public String getCoreJava() {
		return coreJava;
	}




	public void setCoreJava(String coreJava) {
		this.coreJava = coreJava;
	}




	public String getReact() {
		return react;
	}




	public void setReact(String react) {
		this.react = react;
	}




	public String getSpringBoot() {
		return springBoot;
	}




	public void setSpringBoot(String springBoot) {
		this.springBoot = springBoot;
	}




	public String getMySQL() {
		return mySQL;
	}




	public void setMySQL(String mySQL) {
		this.mySQL = mySQL;
	}




	public String getAws() {
		return aws;
	}




	public void setAws(String aws) {
		this.aws = aws;
	}




	public String getClientName() {
		return clientName;
	}




	public void setClientName(String clientName) {
		this.clientName = clientName;
	}




	public String getEvaluatedBy() {
		return evaluatedBy;
	}




	public void setEvaluatedBy(String evaluatedBy) {
		this.evaluatedBy = evaluatedBy;
	}

	
}
