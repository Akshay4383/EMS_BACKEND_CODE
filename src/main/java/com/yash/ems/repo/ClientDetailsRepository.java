package com.yash.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.ems.model.ClientDetails;

@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Integer> {
	
	

}
