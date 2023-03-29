package com.yash.ems.payloads;

import java.util.List;
import java.util.Set;

import com.yash.ems.model.Evaluation;

public class EmployeeDto {

	private int employeeId;
	private String employeeName;
	private String mobileNo;
	
	
	private List<Evaluation> evaluation;
	
	public EmployeeDto(int employeeId, String employeeName, String mobileNo, List<Evaluation> evaluation) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.mobileNo = mobileNo;
		this.evaluation = evaluation;
	}
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<Evaluation> getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(List<Evaluation> evaluation) {
		this.evaluation = evaluation;
	}
	@Override
	public String toString() {
		return "EmployeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", mobileNo=" + mobileNo
				+ ", evaluation=" + evaluation + "]";
	}
	
	
}
