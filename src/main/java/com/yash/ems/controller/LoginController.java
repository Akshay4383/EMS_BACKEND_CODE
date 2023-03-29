package com.yash.ems.controller;
//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.model.Login;
//import com.example.demo.service.LoginService;
//
////@RestController
//public class LoginController {
//
//	
//	@Autowired
//	LoginService studentService;
//	
//	
//	
//	@GetMapping("/loginStudentBy/{username}/{password}")
//	 public ResponseEntity<Login> loginUsernamePassword(@PathVariable("username") String username,@PathVariable("password") String password)
//	 {
//		Login lg = new Login();
//		lg.setUsername("username not Fonud");
//		lg.setPassword("Password Not Found");
//		
//		
//		 Login emp= studentService.logindataByUsernameAndPassword(username,password);
//		 			
//		 if(emp!=null)
//		 {
//			 return new ResponseEntity<Login>(emp,HttpStatus.ACCEPTED);
//		
//		 }
//		 else
//		 {
//			 return new ResponseEntity<Login>(lg,HttpStatus.NOT_ACCEPTABLE);
//		 }
//	 }
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
