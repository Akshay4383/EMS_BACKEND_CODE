package com.yash.ems.service;

import com.yash.ems.model.Registration;

public interface RegistrationService {

	public Registration findByUsernameAndPassword(String username, String password);

	public void saveData(Registration reg);

	public Iterable<Registration> getAllData();

	public Registration findByEmailAndPassword(String email, String password);

}
