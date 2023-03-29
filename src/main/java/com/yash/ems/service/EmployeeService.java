

package com.yash.ems.service;

import java.util.List;


import com.yash.ems.model.Employee;
import com.yash.ems.model.Evaluation;
import com.yash.ems.payloads.EmployeeDto;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	//change to getEmployee
	public List<Employee> getAllEmp();
	
	void deleteEmployee(Integer employeeId);
	
	public Employee updateEmployee(Integer emmployeeId,Employee employeeDto);

	
	public Employee getEmployeeById(Integer employeeId);
	
	public Employee getEmployeeByName(String employeeName);
	
	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId,String employeeName);
	
	//public Evaluation fetchEmployeeNameAndId(String employeeName,Integer employeeId,Evaluation eva);
	
	
	public EmployeeDto searchByEmployeeIdAndEmployeeName(Integer employeeId,String employeeName);
	
	public Employee searchByEmployeeNameOrEmployeeId( String employeeName,Integer employeeId);

	
	public Evaluation addEvatuationDetailsById(Integer employeeId, Evaluation eva);
	
	public Evaluation addEvatuationDetailsByName(String employeeName, Evaluation eva);
	
	

}
