package com.credential.model;

/*
 * Employee class stores the first and last name of employee
 * Constructor with first name & last name.
 * Also it has setter & getter methods.
 */
public class Employee {
	
	private String firstName, lastName;
	
	public Employee(String first, String last){
		this.firstName = first;
		this.lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
