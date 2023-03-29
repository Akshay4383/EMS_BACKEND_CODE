package com.yash.ems.payloads;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yash.ems.model.Employee;

public class EvaluationDto {
	private int evaluationId;
	private Employee employeeId;
	
	private int overallRating;
	private String overallComment;
	@Temporal(TemporalType.DATE)
	private Date evaluationDate;
	
	private String angular;
	
	private String  coreJava;
	
	private String  react;
	private String  springBoot;
	private String  mySQL;
	private String aws;
	public int getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	public int getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(int overallRating) {
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
	
	

}
