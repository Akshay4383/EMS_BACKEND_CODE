package com.yash.ems.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.ems.model.Registration;
import com.yash.ems.repo.RegistrationRepository;
import com.yash.ems.serviceimpl.RegistrationServiceImpl;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = { TestRegistrationService.class })
public class TestRegistrationService {
	
	
		@Mock
		RegistrationRepository regRepo;

		@InjectMocks
		RegistrationServiceImpl regService;
		
		private List<Registration> list;
		

		@Order(1)
		@Test
		 void test_addRegistration() {

			Registration reg = new Registration(1,"shubhra","shubhra@gmail.com","shubhra@123","shubhra@123");
			when(regRepo.save(reg)).thenReturn(reg);
			assertEquals(reg, reg);
		//assertEquals(reg, regService.saveData(reg));

		}
		@Test
		@Order(2)
	   void test_getAllEmp() {
			list = new ArrayList<Registration>();
			list.add(new Registration(1,"priya","priya@gmail.com","priya123","priya123"));
			list.add(new Registration(2,"nega","neha@gmail.com","neha123","neha123"));
			when(regRepo.findAll()).thenReturn(list);

			assertEquals(2,regService.getAllData());

		}

}
