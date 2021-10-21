package com.project01;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String userA = "admin";
	private static final String password = "12345678";
	private static final String db_url = "jdbc:oracle:thin:@database-1.czjydg612bvc.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	
//	public  LoginDAO() {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			Connection conn = DriverManager.getConnection(db_url, userA, pass);
//			System.out.println("HIT");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
		
	public User currUser(String user, String pass) throws ClassNotFoundException {
//		boolean status = false;
		User currUser = new User();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			//open connection
			System.out.println("System is booting");


			Connection conn = DriverManager.getConnection(db_url, userA, password);
			System.out.println("System is online");
			
			//getting data from login table using query
			//creating statement using connection object
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJECT1.USERS WHERE username = ?");

			ps.setString(1, user);

						
			ResultSet rs = ps.executeQuery();
			if( rs.next()) {
				if(pass.equals(rs.getString("password"))) {
//					currUser.setUsername(rs.getString(1));
					//use strings 
					currUser.setUsername(rs.getString(1)) ;
					currUser.setPassword(rs.getString(2)) ;
					currUser.setUserID(rs.getInt(3)) ;
					currUser.setFirstname(rs.getString(4));
					currUser.setLastname(rs.getString(5));
					currUser.setEmail(rs.getString(6));
					currUser.setPhoneNum(rs.getString(7));
					conn.close();
				}
				else {
					//if the username is null/not found, set the ID to 3
					System.out.println("Wrong password");
					currUser.setUserID(3) ;

				}
			}
			else {
				//if the username is null/not found, set the ID to 3
				System.out.println("User not found!");
				currUser.setUserID(3) ;

				
			}
						
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return currUser;
	}
	

}
