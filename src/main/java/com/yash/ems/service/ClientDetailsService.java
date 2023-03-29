package com.yash.ems.service;

import java.util.List;

import com.yash.ems.model.ClientDetails;


public interface ClientDetailsService  {
	
	public ClientDetails addClient(ClientDetails client);
	
	public List<ClientDetails> getAllClient();
	
	void deleteClient(Integer clientId);
	

}
