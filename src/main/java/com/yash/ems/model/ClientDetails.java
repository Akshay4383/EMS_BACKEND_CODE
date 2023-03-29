package com.yash.ems.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ClientDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	
	private String clientName;

	public ClientDetails() {
	
	}

	public ClientDetails(int clientId, String clientName) {
		//super();
		this.clientId = clientId;
		this.clientName = clientName;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + "]";
	}
	
	

}
