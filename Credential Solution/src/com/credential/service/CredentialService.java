package com.credential.service;

import java.lang.Math;
import com.credential.model.Employee;
import java.util.Scanner;

/*
 * Below class accepts Employee as parameter and with the methods
 * user can create credentials, Email & password.
 */
public class CredentialService {
	
	String company = "Lakes";
	Employee emp;
	int dept=0;
	Scanner sc = new Scanner(System.in);
	
	//Array of special characters for password
	int[] splChrs = {33,35,36,37,38,42,43,45,64};
	//Array of departments
	String[] depts = {"Technical", "Admin", "Human_Resource", "Legal"};
	
	//constructor with employee parameter
	public CredentialService(Employee emp) {
		this.emp = emp;
		this.dept = 0;
	}
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
		this.dept = 0;
	}

	//Creates Email, Password and displays
	public void showCredentials() {
		if (dept==0) {
			getDepartment();}
		System.out.println("Dear " + emp.getFirstName() + " your generated credentials are as follows:");
		System.out.println("Email    --> " + generateEmailAddress());
		System.out.println("Password --> " + generatePassword());
	}
	
	//Generates and returns email - String
	public String generateEmailAddress() {
		if (dept==0) {
			getDepartment();}
		String mail;
		mail = emp.getFirstName() + emp.getLastName() + "@"+depts[dept-1] + "." + company + ".com";
		return mail.toLowerCase();
	}

	
	 // Below method takes input from user about department 
	private void getDepartment() {
		int i =0;
		boolean crctChoice = false;
		do {
			System.out.println("---- WELCOME TO COMPANY CREDENTIAL SYSTEM ----");
			System.out.println("Please enter the department from the following");
			for (i = 0; i<4; i++)
				System.out.println((i+1) + ". " + depts[i]);
			dept = sc.nextInt();
			if (dept<1 || dept > depts.length) {
				System.out.println("You have opted a wrong option! ");
			}
			else {
				crctChoice = true;}
		}while(crctChoice==false);
	}
	
/*
 * Generates 8 character long password meeting below condition:
 * at least 1 number, 1 Capital letter, 1 Small letter & 1 Special character. 
 */
	public String generatePassword() {
		int pswdLn, chrTyp, i;
		String pswd;
		boolean digi=false, cap=false, sml=false, spec=false, all=false;
		
		pswdLn = 8; //Length of password
		//enters into a loop, will quit only if password criteria is met
		do {
			pswd = "";
			//For loop builds the password as per password length
			for (i = 1; i <= pswdLn; i++) {
				//Randomly decides which character should be chosen next
				//(digit, capital, small, special character)
				chrTyp = digit(1,4);
				switch(chrTyp) {
				case 1:	//digit
					pswd = pswd + digit(0,9);
					digi = true;
					break;
				case 2:	//capital letter
					pswd = pswd + (char) digit(65,90);
					cap = true;
					break;
				case 3:	//Small letter
					pswd = pswd + (char) digit(97,122);
					sml = true;
					break;
				case 4:	//Special character
					pswd = pswd + (char) splChrs[digit(0,8)];
					spec = true;
				}
			}
			//Checking all password criteria are met or not
			if (digi == true && cap == true && sml == true && spec == true) {
				all = true;}
		}while(all==false);
		return pswd;
	}

	//returns random digit of given choice
	private int digit(int mn, int mx) {
		return (int) (Math.random() * (mx - mn + 1) + mn);  
	}	
}
