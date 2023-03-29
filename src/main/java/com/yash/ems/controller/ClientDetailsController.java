package com.yash.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.ems.model.ClientDetails;
import com.yash.ems.service.ClientDetailsService;


@CrossOrigin("*")
@RestController
@RequestMapping("/ems/client")
public class ClientDetailsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDetailsController.class);

	
	
	@Autowired
	private ClientDetailsService clientService;
	
	
	@PostMapping("/addclient")
	public ResponseEntity<ClientDetails> saveClient( @RequestBody ClientDetails client) {
		
		LOGGER.info("Create Client Data...");
		
		ClientDetails addClient = this.clientService.addClient(client);
		return new ResponseEntity<ClientDetails>(addClient,HttpStatus.CREATED);
	}

	@GetMapping("/get-all-client-details")
	public ResponseEntity<List<ClientDetails>> getAll() {
		
		LOGGER.info("Show onboard Client details");
		List<ClientDetails> allClient = this.clientService.getAllClient();
		return  new ResponseEntity<List<ClientDetails>>(allClient,HttpStatus.OK);
	}

	
	
	 
	@DeleteMapping("/delete-client/{clientId}")
	public ResponseEntity<ClientDetails> deleteClient(@PathVariable Integer clientId) {
		
		LOGGER.info("Show delete Client details");
		this.clientService.deleteClient(clientId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
