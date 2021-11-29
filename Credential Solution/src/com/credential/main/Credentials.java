package com.credential.main;

import com.credential.service.CredentialService;
import com.credential.model.Employee;

/*
 * Driver class
 */
public class Credentials {

	public static void main(String[] args) {

		Employee emp = new Employee("Shain", "Joy");
		CredentialService cs = new CredentialService(emp);
		
		cs.showCredentials();
		
	}

}
