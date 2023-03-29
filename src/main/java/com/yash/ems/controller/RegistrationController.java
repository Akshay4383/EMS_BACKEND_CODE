package com.yash.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.Registration;
import com.yash.ems.serviceimpl.RegistrationServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/ems/register")
public class RegistrationController {

	
	@Autowired
	RegistrationServiceImpl regService;
	

	@PostMapping("/loginuser")  
	   public String loginUser(@RequestBody Registration r) throws Exception
	   {
	       String username=r.getUsername();
	       String password=r.getPassword();
	       
	       Registration regobj =null;
	       System.out.println(username +" "+password);
	       
	       if(username !=null && password !=null)
	       {
	           regobj =regService.findByUsernameAndPassword(username,password);
	       }
	       
	       
	       
	       if(regobj.getUsername().equals(username) && regobj.getPassword().equals(password) ) {
	    	  // return regobj;
	    	   return "login successfully";
	       }
	       else {
	    	  
	    	   System.out.println(regobj+" login is not successfull");
	    	   return "login unsuccessfull";
	       }
	       
	           //return r;
	           
	           
	   }
	   
	
	
	@GetMapping("/getAllData")
	public Iterable<Registration> getAllData()
	{
		
		 Iterable<Registration> em=regService.getAllData();
		
		return em;
	}
	
	
	 @GetMapping("/loginBy/{username}/{password}")
	 public Registration loginUsernamePassword(@PathVariable("username") String username,@PathVariable("password") String password)
	 {
		 Registration ee= new Registration();
		 
		 Registration emp= regService.findByUsernameAndPassword(username,password);
		 				
		 ee.setUsername(username);
		 ee.setPassword(password);
		 return ee;	 
	 }
	 @PostMapping("/saveData")
	 public ResponseEntity<String> saveData(@RequestBody Registration reg)
	 {
		 
		 regService.saveData(reg);
		 
		 
		 return new ResponseEntity<String>("Your Data Is Save",HttpStatus.OK);
		 
	 }
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
