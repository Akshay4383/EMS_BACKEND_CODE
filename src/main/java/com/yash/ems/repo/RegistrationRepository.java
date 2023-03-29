package com.yash.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.yash.ems.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
	
	
	
	
	public Registration findByUsernameAndPassword(String username, String password);
	public Registration findByEmailAndPassword(String email, String password);
}

