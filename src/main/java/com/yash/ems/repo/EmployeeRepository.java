package com.yash.ems.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName);
	
	public Employee searchByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName);
	
	public Employee findByEmployeeNameOrEmployeeId( @Param("employeeName") String employeeName,
			                        @Param("employeeId") Integer employeeId);
	
	public Optional<Employee> findByEmployeeName(String employeeName);
	
//	@Query("select  employee_name ,employee_id from employee")
//	public Employee searchByEmployeeNameAndEmployeeId(@Param("employeeName") String employeeName,
//            @Param("employeeId") Integer employeeId);

}
