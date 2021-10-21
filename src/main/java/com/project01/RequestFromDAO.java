package com.project01;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RequestFromDAO {
	private String firstname, lastname, email, descript, mobile;
	private double amount, date;
	private Scanner in = new Scanner(System.in);
	
	public void insertIntoRegister() { 
//		System.out.println("--------------------------------------------------------------");
//		System.out.println("Welcome new coming user!");
//		System.out.print("Please enter your first name: ");
//		this.firstname = in.nextLine();
//
//		System.out.print("Please enter your last name: ");
//		this.lastname = in.nextLine();
//
//
//		System.out.print("Please enter your email address: ");
//		this.email = in.nextLine();
//
//		do {
//			System.out.print("Please enter a password you would like: ");
//			System.out.println("\nYour password must have: \n* At least 8 characters"
//					+ "\n* Must not contain space");
//			System.out.print("Password: ");
//			this.pass = in.nextLine();
//			if(this.pass.length() < 8) {
//				System.out.println("Please enter up to 8 characters");
//			}
//			if(this.pass.contains(" ")) {
//				System.out.println("Space is not allowed!");
//			}
//
//		}while( (this.pass.length() < 8) || this.pass.contains(" "));
//
//		do {
//			System.out.print("Please enter your last 4-digit SSN: ");
//			this.ssn = in.nextLine();
//			if(this.ssn.length() > 4 ) {
//				System.out.println("4 digit limit");
//			}
//			else if(this.ssn.length() < 4 ) {
//				System.out.println("Please enter up to 4 digits");
//			}
//		}while(this.ssn.length() != 4);
//		System.out.println("\nThank you for registering with Dream Bank! We are processing your information. "
//				+ "\nYour account is pending, and will have to be approved."
//				+ "\n"
//				+ "\nNote: Your account ID is the last 4 digits of your SSN");
//		
//		
//		String safe = "INSERT INTO REGISTER VALUES (?, ?, ?, ?, ?, ?)"; 
//		PreparedStatement push;   
//		try {             
//			push = conn.prepareStatement(safe);                        
//			push.setString(1, this.firstname);             
//			push.setString(2, this.lastname);             
//			push.setString(3, this.username);
//			push.setString(4, this.pass);             
//			push.setString(5, this.ssn);             
//			push.setString(6, "Pending");
//			int row = push.executeUpdate();                         
//			System.out.println("Sucessfuly Insert");             
//		}
//		catch (SQLException e){ 
//			e.printStackTrace();
//		}
		
		System.out.print("Please enter your first name: ");
		this.firstname = in.nextLine();

		System.out.print("Please enter your last name: ");
		this.lastname = in.nextLine();

		do {
			System.out.print("Please enter your email address: ");
			this.email = in.nextLine();
			if(loginInfo.containsKey(user)) {
				System.out.println("That username is taken.");
			}
		}while(loginInfo.containsKey(user));

		do {
			System.out.print("Please enter a password you would like: ");
			System.out.println("\nYour password must have: \n* At least 8 characters"
					+ "\n* Must not contain space");
			System.out.print("Password: ");
			this.mobile = in.nextLine();
			if(this.mobile.length() < 8) {
				System.out.println("Please enter up to 8 characters");
			}
			if(this.mobile.length() > 10) {
				System.out.println("You've reached the max length");
			}
			//			if(!this.pass.contains()) {
			//				System.out.println("Please input at least 1 number!");
			//			}

		}while( (this.mobile.length() < 8) || this.mobile.length() > 10);

		do {
			System.out.print("Please enter your last 4-digit SSN: ");
			this.ssn = in.nextLine();
			if(this.ssn.length() > 4 ) {
				System.out.println("4 digit limit");
			}
			else if(this.ssn.length() < 4 ) {
				System.out.println("Please enter up to 4 digits");
			}
			else if(userCustomers.containsKey(this.ssn)) {
				System.out.println("That SSN has already been registerd!");	

			}
		}while(this.ssn.length() != 4 || userCustomers.containsKey(this.ssn));
		System.out.println("\nThank you for registering with Dream Bank! We are processing your information. "
				+ "\nYour account is pending, and will have to be approved."
				+ "\n"
				+ "\nNote: Your account ID is the last 4 digits of your SSN");

	}


}
