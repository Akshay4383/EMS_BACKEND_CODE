package com.yash.ems.model;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int employeeId;
	@NotEmpty(message = "Name must be enter")
	private String employeeName;
	@NotEmpty(message = "grade should not emplty")
	private String grade;
	// @JsonFormat(pattern="yyyy-MM-dd")
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	// @JsonFormat(pattern="yyyy-MM-dd")
	 @Temporal(TemporalType.DATE) 
	private Date dateOfJoining;
	
	 @NotEmpty(message = "Mobile number not be ")
	private String mobileNo;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@NotEmpty(message = "email must be enter")
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	private String exprience;
	private String exprienceInYash;
	private String totalExprience;
	@NotEmpty(message = "BaseLocation must be enter")
	private String baseLocation;
	private String currentLocation;
	
	private String primarySkills;
	private String secondarySkills;
	
	//@NotEmpty(message = "You must be enter ")
	private String designation;
	
	private String frontendSpecialization;
	private String cloudTech;


	
	@OneToMany(targetEntity = Evaluation.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "evaluatin_emp_fk")
	private List<Evaluation> evaluation;
	
	public Employee() {
	
	}


	public Employee(int employeeId, @NotEmpty(message = "Name must be enter") String employeeName,
			@NotEmpty(message = "grade should not emplty") String grade, Date dob, Date dateOfJoining,
			@NotEmpty(message = "Mobile number not be ") String mobileNo,
			@NotEmpty(message = "email must be enter") @Email @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email,
			String exprience, String exprienceInYash, String totalExprience,
			@NotEmpty(message = "BaseLocation must be enter") String baseLocation, String currentLocation,
			String primarySkills, String secondarySkills,String designation,
			String frontendSpecialization, String cloudTech, List<Evaluation> evaluation) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.grade = grade;
		this.dob = dob;
		this.dateOfJoining = dateOfJoining;
		this.mobileNo = mobileNo;
		this.email = email;
		this.exprience = exprience;
		this.exprienceInYash = exprienceInYash;
		this.totalExprience = totalExprience;
		this.baseLocation = baseLocation;
		this.currentLocation = currentLocation;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.designation = designation;
		this.frontendSpecialization = frontendSpecialization;
		this.cloudTech = cloudTech;
		this.evaluation = evaluation;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExprience() {
		return exprience;
	}

	public void setExprience(String exprience) {
		this.exprience = exprience;
	}

	public String getExprienceInYash() {
		return exprienceInYash;
	}

	public void setExprienceInYash(String exprienceInYash) {
		this.exprienceInYash = exprienceInYash;
	}

	public String getTotalExprience() {
		return totalExprience;
	}

	public void setTotalExprience(String totalExprience) {
		this.totalExprience = totalExprience;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public String getFrontendSpecialization() {
		return frontendSpecialization;
	}

	public void setFrontendSpecialization(String frontendSpecialization) {
		this.frontendSpecialization = frontendSpecialization;
	}

	public String getCloudTech() {
		return cloudTech;
	}

	public void setCloudTech(String cloudTech) {
		this.cloudTech = cloudTech;
	}

	public List<Evaluation> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	
	

	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", grade=" + grade + ", dob="
				+ dob + ", dateOfJoining=" + dateOfJoining + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", exprience=" + exprience + ", exprienceInYash=" + exprienceInYash + ", totalExprience="
				+ totalExprience + ", baseLocation=" + baseLocation + ", currentLocation=" + currentLocation
				+ ", primarySkills=" + primarySkills + ", secondarySkills=" + secondarySkills + ", designation="
				+ designation + ", frontendSpecialization=" + frontendSpecialization + ", cloudTech=" + cloudTech
				+ ", evaluation=" + evaluation + "]";
	}

	
	
}

/*{
     "employeeId": 1,
        "employeeName": "Shubhangi J. Kamble",
        "grade": "E1",
        "dob": "1996-07-27",
        "dateOfJoining": "2022-09-25",
        "mobileNo": "9087654567",
        "email": "shubhra@yash.com",
        "exprience": "2.8",
        "exprienceInYash": "0.5",
        "totalExprience": "2.10",
        "baseLocation": "Indore",
        "currentLocation": "Magarpatta",
        "primarySkills": "Core java, spring boot",
        "secondarySkills": "mysql,angular",
        "frontendSpecialization": "Angular",
        "cloudTech": "Na",
        "evaluation": [
            {
                "evaluationId": 2,
                "overallRating": 4,
                "overallComment": "good",
                "evaluationDate": null,
                "skills": []
            }
        ]
}
*/
