//package com.yash.ems.repo;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.yash.ems.model.Registration;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//public class TestRegistrationRepo {
//	@Autowired
//	private RegistrationRepository regRepo;
//	
//	@Test
//	public void testDaveRegistration()
//	{
//		Registration reg=regRepo.save(new Registration(1,"priya","priya@gmail.com","priya123","priya123"));
//		assertNotNull(reg);
//		assertTrue(reg.getId()>0);
//	}
//
//
//}
