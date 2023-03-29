package com.yash.ems.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.ems.model.ClientDetails;
import com.yash.ems.repo.ClientDetailsRepository;

import com.yash.ems.service.ClientDetailsService;


@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
	
	
	@Autowired
	private ClientDetailsRepository clientRepository;

	@Override
	public ClientDetails addClient(ClientDetails client) {
		ClientDetails addclient = clientRepository.save(client);
		return addclient;
	}

	@Override
	public List<ClientDetails> getAllClient() {
		List<ClientDetails> findAllClient = clientRepository.findAll();
		return findAllClient;
	}

	@Override
	public void deleteClient(Integer clientId) {
		clientRepository.deleteById(clientId);
		
	}

}
