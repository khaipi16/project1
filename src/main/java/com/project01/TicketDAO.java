package com.project01;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.Gson;

public class TicketDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private final String user = "admin";
	private final String password = "12345678";
	private final String db_url = "jdbc:oracle:thin:@database-1.czjydg612bvc.us-east-2.rds.amazonaws.com:1521:ORCL";
	//	private String firstname, lastname, email, descript, mobile, type, date;
	//	private double amount;
	//	private Scanner in = new Scanner(System.in);
	@SuppressWarnings("static-access")
	public void insertTicket(Ticket newTicket) { 
		try {
			System.out.println("Inside TicketDAO before catch statement");
			//loading the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//
			this.conn = DriverManager.getConnection(this.db_url, this.user, this.password);
			System.out.println("Establishing connection...");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Unable to load driver class");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException caught!");
		}


		String safe = "INSERT INTO PROJECT1.ERS_REIMB VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		PreparedStatement push;   
		System.out.println("Printing Ticket ID: " + newTicket.generateID());
		System.out.println("Printing Author: " + newTicket.getAuthor());
		System.out.println("Printing Type: " + newTicket.getType());
		System.out.println("Printing Amount: " + newTicket.getAmount());
		System.out.println("Printing Description: " + newTicket.getDescription());
		System.out.println("Printing Date: " + newTicket.generateDate());
		System.out.println("Printing Resolved: " + newTicket.getResolved());
		System.out.println("Printing Resolver: " + newTicket.getResolver());
		System.out.println("Printing Status: " + newTicket.getStatus());		//going to be null

		try {             
			push = conn.prepareStatement(safe);                         
			push.setInt(1, newTicket.generateID());  
			push.setString(2, newTicket.getAuthor());
			push.setString(3, newTicket.getType()); 
			push.setString(4, newTicket.getAmount());
			push.setString(5, newTicket.getDescription());
			push.setTimestamp(6, newTicket.generateDate());
			push.setString(7, "Pending");  
			push.setString(8, null);
			push.setTimestamp(9, null);
			int row = push.executeUpdate();     

			System.out.println("Sucessfuly Insert");   
			conn.close();
		}
		catch (SQLException e){ 
			e.printStackTrace();
		}
		
	}
	
	public void isApprove(String user) {
		
	}

	@SuppressWarnings("unused")
	public ArrayList<Ticket> getAllTickets(){
		ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
		try 
		{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = DriverManager.getConnection(this.db_url, this.user, this.password);
			System.out.println("System is online");
			
			String safeQuery = "SELECT * from Project1.ERS_REIMB";

			PreparedStatement ps = conn.prepareStatement(safeQuery); 
			
//			ps.setString(2, user);
			ResultSet rs = ps.executeQuery();  
						
			while (rs.next()) 
			{  
				Ticket addTicket = new Ticket();

				addTicket.setTicketID(rs.getInt(1));
				addTicket.setAuthor(rs.getString(2));
				addTicket.setType(rs.getString(3));
				addTicket.setAmount(rs.getString(4));
				addTicket.setDescript(rs.getString(5));
				addTicket.setSubmitted(rs.getDate(6));
				addTicket.setStatus(rs.getString(7));
				
				allTickets.add(addTicket);
			}  
			conn.close();
		}catch (Exception e) 
		{  
			System.out.println("Ticket DAO error");  
		} 
		return allTickets;
	}
	
	public void updateStatus(int id, String status, String user) {
		//initially check for status using id and username to identify ticket
	
		try {
			//open connection
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			System.out.println("System is booting");
			this.conn = DriverManager.getConnection(this.db_url, this.user, this.password);
			System.out.println("System is online");
			
			//generating a timestamp of when ticket is approved
			Timestamp time = new Timestamp(System.currentTimeMillis());
			System.out.println("Resolver DAO: " + time);
			
			PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM PROJECT1.ERS_REIMB WHERE TICKETID = ?");
			ps1.setInt(1, id);
			System.out.println("before exeQuery");
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
//				if(status.equals(rs.getString("status"))) {
//				}

				//creating statement using connection object
				System.out.println("Inside Update Status");
				PreparedStatement ps = conn.prepareStatement("UPDATE PROJECT1.ERS_REIMB SET STATUS = ?, RESOLVER = ?, RESOLVED = ? WHERE TICKETID = ?");
				ps.setString(1, status);
				ps.setString(2, user);
				ps.setTimestamp(3, time);
				ps.setInt(4, id);
				ps.executeUpdate();
				conn.close();
			}
			else {
				System.out.println("Ticket ID not found");
			
			}
		
//			, STATUS = ?, RESOLVER = ?, RESOLVED = ?"
	
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Successfully Updated Status");	 

	}

	@SuppressWarnings("unused")
	public ArrayList<Ticket> getAllTicketsByUser(String user){
		ArrayList<Ticket> allTickets = new ArrayList<Ticket>();
		Ticket addTicket = new Ticket();
		try 
		{  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(this.db_url, this.user, this.password);
			System.out.println("System is online");

			String safeQuery = "SELECT * from Project1.ERS_REIMB WHERE AUTHOR = ?"; 
			PreparedStatement ps = conn.prepareStatement(safeQuery);  

			ps.setString(2, user);
			ResultSet rs = ps.executeQuery();

			if(!rs.next()) {
				return allTickets;
			}
			else {
				do 
				{  
					addTicket.setTicketID(rs.getInt(1));
					addTicket.setAuthor(rs.getString(2));
					addTicket.setType(rs.getString(3));
					addTicket.setAmount(rs.getString(4));
					addTicket.setDescript(rs.getString(5));
					addTicket.setSubmitted(rs.getDate(6));
					addTicket.setStatus(rs.getString(7));
					
					allTickets.add(addTicket);

				} while (rs.next()); 
				conn.close();

			}
		}catch (Exception e) 
		{  
			System.out.println("error");  
		} 
		return allTickets;
	}

}
