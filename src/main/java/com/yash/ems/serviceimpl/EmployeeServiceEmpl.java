package com.yash.ems.serviceimpl;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.model.Employee;
import com.yash.ems.model.Evaluation;
import com.yash.ems.payloads.EmployeeDto;
import com.yash.ems.repo.EmployeeRepository;
import com.yash.ems.service.EmployeeService;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ModelMapper mapper;
	

	DateTimeFormatter dateTimeFormmater = DateTimeFormatter.ofPattern("yyyy-dd-MM");

	@Override
	public Employee addEmployee(Employee employee) {
	
		return  empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmp() {

		
		List<Employee> empList = new ArrayList<>();
		
		Employee emp=new Employee();
		
		try {
			if (empRepo.findAll() != null || empRepo.findAll().size() > 0) {
				empList = calcuteYashExperience(empRepo.findAll());
			
			
				System.out.println("empLists :"+empList.size());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("emp.getExprienceInYash()"+emp.getExprienceInYash());
	
		
		return empList;
		
		
	}

	//CALCULATE YASH EXPRIENCE
	
	private List<Employee> calcuteYashExperience(List<Employee> empList) {
		Employee emp = null;
		List<Employee> lists = new ArrayList<>();
		java.util.Date currentDate = new java.util.Date(System.currentTimeMillis());
		 int years_difference = 0;
	      int months_difference = 0;
	        int totalyearsExp;
	        int totalmthExp;
	        int parse5;
	        for (Employee e : empList) {
	            if (e != null) {
	                emp = e;
	                //Calculate YashExperience               
	             Date dateOfJoining = emp.getDateOfJoining();
	                long time_difference = currentDate.getTime() - dateOfJoining.getTime();
	                // calculate months               
	               long differenceInMonths = TimeUnit.MILLISECONDS.toDays(time_difference) / 30;
	                if (differenceInMonths % 12 == 0) {
	                    years_difference = (int) differenceInMonths / 12;
	                    months_difference = 0;
	                } else {
	                    years_difference = (int) differenceInMonths / 12;
	                    months_difference = (int) differenceInMonths % 12;
	                }
	                emp.setExprienceInYash(years_difference+"."+months_difference);
			//	emp.setTotalExprience(emp.getExprience()+yashExperience);
				//emp.setExp(years_difference+months_difference/10);
				System.out.println("yash exp "+ emp.getExprienceInYash());
				
				 //Calculate TotalExperience     
				
				String prevExp = emp.getExprience();
		                String currentExp = emp.getExprienceInYash();
		                String[] split1 = prevExp.split("\\.");
		                int parseInt1 = Integer.parseInt(split1[0]);
		                int parseInt2 = Integer.parseInt(split1[1]);
		                String[] split2 = currentExp.split("\\.");
		                int parseInt3 = Integer.parseInt(split2[0]);
		                int parseInt4 = Integer.parseInt(split2[1]);
		                if (parseInt2 + parseInt4 > 12) {
		                    parse5 = parseInt2 + parseInt4;
		                    int month = parse5 % 12;
		                    totalyearsExp = parseInt1 + parseInt3 + 1;
		                    System.out.println("totalyearsExp " + totalyearsExp);
		                    totalmthExp = month;
		                    System.out.println("totalMthExp " + totalmthExp);
		                } else {
		                    totalmthExp = parseInt2 + parseInt4;
		                    totalyearsExp = parseInt1 + parseInt3;
		                    System.out.println("totalyearsExp " + totalyearsExp);
		                    System.out.println("totalMthExp " + totalmthExp);
		                }
		                //emp.setTota
		                emp.setTotalExprience(totalyearsExp + "." + totalmthExp);
			}
			lists.add(emp);
		
		}

		return lists;
	}

	

	public void setDate(Employee e) {

		Date d = e.getDateOfJoining();
		System.out.println(d);
	}
	
	@Override
	public void deleteEmployee(Integer employeeId) {
		empRepo.deleteById(employeeId);

			
	}

	@Override
	public Employee updateEmployee(Integer emmployeeId,Employee emp) {
      Optional<Employee> op = empRepo.findById(emmployeeId);
      
		
		if (op.isPresent()) {
			Employee eo = op.get();
			eo.setEmployeeId(emp.getEmployeeId());
			eo.setEmployeeName(emp.getEmployeeName());
			eo.setGrade(emp.getGrade());
			eo.setDob(emp.getDob());
			eo.setEmail(emp.getEmail());
			eo.setMobileNo(emp.getMobileNo());
			eo.setDateOfJoining(emp.getDateOfJoining());
			eo.setExprience(emp.getExprience());
			eo.setBaseLocation(emp.getBaseLocation());
			eo.setCurrentLocation(emp.getCurrentLocation());
			eo.setExprienceInYash(emp.getExprienceInYash());
			eo.setTotalExprience(emp.getTotalExprience());
			eo.setCloudTech(emp.getCloudTech());
			eo.setFrontendSpecialization(emp.getFrontendSpecialization());
			
			

			empRepo.save(emp);
		} else {
			System.out.println("Employee not available");
		}
		System.out.println("Employee Updating Successfully ");
		return emp;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
//		List<Employee> empList = new ArrayList<>();
//		empList = calcuteYashExperience(empRepo.findAll());
//		Employee id = null;
//		Iterator<Employee> i= empList.iterator();
//		while(i.hasNext())
//		{
//			id=i.next();
//			
//		}
		return empRepo.findById(employeeId).get();
	}

	

    public EmployeeDto convertEntityToDto(Employee employee) {
		
		EmployeeDto employeeDto=new EmployeeDto();
		
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setMobileNo(employee.getMobileNo());
		employeeDto.setEvaluation(employee.getEvaluation());
		
		
		return employeeDto;
		
	}
	
	@Override
	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {
		
		return empRepo.findByEmployeeIdAndEmployeeName(employeeId, employeeName);
	}

	@Override
	public EmployeeDto searchByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {
		// TODO Auto-generated method stub
		Employee employee=empRepo.searchByEmployeeIdAndEmployeeName(employeeId, employeeName);
		
		return this.convertEntityToDto(employee);
	}

	@Override
	public Evaluation addEvatuationDetailsById(Integer employeeId, Evaluation eva) {
		Optional<Employee> op = empRepo.findById(employeeId);
	     
		Evaluation eval=new Evaluation();
		List<Evaluation> eList=new ArrayList<>();
	
		if (op.isPresent() ) {
			Employee eo = op.get();
			
			eList=eo.getEvaluation();
					
			
			eval.setEvaluationDate(eva.getEvaluationDate());
			eval.setOverallComment(eva.getOverallComment());
			eval.setOverallRating(eva.getOverallRating());
			eval.setAngular(eva.getAngular());
			eval.setAws(eva.getAws());
			eval.setCoreJava(eva.getCoreJava());
			eval.setMySQL(eva.getMySQL());
			eval.setReact(eva.getReact());
			eval.setSpringBoot(eva.getSpringBoot());
			
			//eval.setRating(eva.getRating());
			eList.add(eval);
	
		    eo.setEvaluation(eList);
		     
		   
			empRepo.save(eo);
		} else {
			System.out.println("Evaluation not available");
		}



		System.out.println("Evaluation Updating Successfully ");
		System.out.println(eva);
		return eva;
	}

	@Override
	public Employee searchByEmployeeNameOrEmployeeId( String employeeName, Integer employeeId) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeNameOrEmployeeId( employeeName,employeeId);
	}

	@Override
	public Employee getEmployeeByName(String employeeName) {
		
		return empRepo.findByEmployeeName(employeeName).get();
	}

	@Override
	public Evaluation addEvatuationDetailsByName(String employeeName, Evaluation eva) {
		Optional<Employee> op = empRepo.findByEmployeeName(employeeName);

         Evaluation eval=new Evaluation();
		List<Evaluation> eList=new ArrayList<>();
	
		if (op.isPresent() ) {
			Employee eo = op.get();
			
			eList=eo.getEvaluation();
					
			
			eval.setEvaluationDate(eva.getEvaluationDate());
			eval.setOverallComment(eva.getOverallComment());
			eval.setOverallRating(eva.getOverallRating());
			eval.setAngular(eva.getAngular());
			eval.setAws(eva.getAws());
			eval.setCoreJava(eva.getCoreJava());
			eval.setMySQL(eva.getMySQL());
			eval.setReact(eva.getReact());
			eval.setSpringBoot(eva.getSpringBoot());
			
			//eval.setRating(eva.getRating());
			eList.add(eval);
	
		    eo.setEvaluation(eList);
		     
		   
			empRepo.save(eo);
		} else {
			System.out.println("Evaluation not available");
		}



		System.out.println("Evaluation Updating Successfully ");
		System.out.println(eva);
		return eva;
	}

//	@Override
//	public Evaluation fetchEmployeeNameAndId(String employeeName, Integer employeeId, Evaluation eva) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Override
	public List<EmployeeDto> getAllEmp() {
		List<EmployeeDto> empList = new ArrayList<>();
		Employee emp=new Employee();
		
		try {
			if (empRepo.findAll() != null || empRepo.findAll().size() > 0) {
				empList = calcuteYashExperience(empRepo.findAll());
				//empList = calcuteTotalExperience(empRepo.findAll());
			
				System.out.println("empLists :"+empList.size());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("emp.getExprienceInYash()"+emp.getExprienceInYash());
		
		return empList;
	}

	private List<EmployeeDto> calcuteYashExperience(List<EmployeeDto> empList) {
		EmployeeDto emp = null;
		List<EmployeeDto> lists = new ArrayList<>();
		java.util.Date currentDate = new java.util.Date(System.currentTimeMillis());
		 int years_difference = 0;
	      int months_difference = 0;
	        int totalyearsExp;
	        int totalmthExp;
	        int parse5;
	        for (Employee e : empList) {
	            if (e != null) {
	                emp = e;
	                //Calculate YashExperience               
	             Date dateOfJoining = emp.getDateOfJoining();
	                long time_difference = currentDate.getTime() - dateOfJoining.getTime();
	                // calculate months               
	               long differenceInMonths = TimeUnit.MILLISECONDS.toDays(time_difference) / 30;
	                if (differenceInMonths % 12 == 0) {
	                    years_difference = (int) differenceInMonths / 12;
	                    months_difference = 0;
	                } else {
	                    years_difference = (int) differenceInMonths / 12;
	                    months_difference = (int) differenceInMonths % 12;
	                }
	                emp.setExprienceInYash(years_difference+"."+months_difference);
			//	emp.setTotalExprience(emp.getExprience()+yashExperience);
				//emp.setExp(years_difference+months_difference/10);
				System.out.println("yash exp "+ emp.getExprienceInYash());
				
				 //Calculate TotalExperience     
				
				String prevExp = emp.getExprience();
		                String currentExp = emp.getExprienceInYash();
		                String[] split1 = prevExp.split("\\.");
		                int parseInt1 = Integer.parseInt(split1[0]);
		                int parseInt2 = Integer.parseInt(split1[1]);
		                String[] split2 = currentExp.split("\\.");
		                int parseInt3 = Integer.parseInt(split2[0]);
		                int parseInt4 = Integer.parseInt(split2[1]);
		                if (parseInt2 + parseInt4 > 12) {
		                    parse5 = parseInt2 + parseInt4;
		                    int month = parse5 % 12;
		                    totalyearsExp = parseInt1 + parseInt3 + 1;
		                    System.out.println("totalyearsExp " + totalyearsExp);
		                    totalmthExp = month;
		                    System.out.println("totalMthExp " + totalmthExp);
		                } else {
		                    totalmthExp = parseInt2 + parseInt4;
		                    totalyearsExp = parseInt1 + parseInt3;
		                    System.out.println("totalyearsExp " + totalyearsExp);
		                    System.out.println("totalMthExp " + totalmthExp);
		                }
		                //emp.setTota
		                emp.setTotalExprience(totalyearsExp + "." + totalmthExp);
			}
			lists.add(emp);
		
		}

		return lists;
	}

	
	
	public void setDate(Employee e) {

		Date d = e.getDateOfJoining();
		System.out.println(d);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		empRepo.deleteById(employeeId);

	}

	@Override
	public Optional<EmployeeDto> getEmployeeById(Integer employeeId) {
		List<Employee> empList = new ArrayList<>();
		empList = calcuteYashExperience(empRepo.findAll());
		Employee id = null;
		Iterator<Employee> i= empList.iterator();
		while(i.hasNext())
		{
			id=i.next();
			
		}
		return empRepo.findById(id.getEmployeeId());
	}

	@Override
	public Employee findByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeIdAndEmployeeName(employeeId, employeeName);
	}

	
	
	
    public EmployeeDto convertEntityToDto(Employee employee) {
		
		EmployeeDto employeeDto=new EmployeeDto();
		
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setMobileNo(employee.getMobileNo());
		employeeDto.setEvaluation(employee.getEvaluation());
		
		
		return employeeDto;
		
	}

	@Override
	public EmployeeDto searchByEmployeeIdAndEmployeeName(Integer employeeId, String employeeName) {
		// TODO Auto-generated method stub
		Employee employee=empRepo.searchByEmployeeIdAndEmployeeName(employeeId, employeeName);
		
		return this.convertEntityToDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer emmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
