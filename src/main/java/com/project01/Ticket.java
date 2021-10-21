package com.project01;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type, amount, description, reciept, author, status;
	private int TicketID, resolver;
	private Date submitted, resolved;
	
	
	
	
//	public Ticket(String iD, String amount, String submitted, String resolved, String descript, String reciept,
//			String author, String resolver, String statusID, String typeID) {
//		super();
//		this.ID = iD;
//		this.amount = amount;
//		this.submitted = submitted;
//		this.resolved = resolved;
//		this.descript = descript;
//		this.reciept = reciept;
//		this.author = author;
//		this.resolver = resolver;
//		this.statusID = statusID;
//		this.typeID = typeID;
//	}
	
	public Ticket(int TicketID, String author, String type, String amount, String description, Date submitted, String status) {
		this.TicketID = TicketID;
		this.author = author;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = null;
//		this.resolver = "";
		this.status = status;
	
	}
	
	public Ticket() {
		
	}

	public static int generateID(){
		Random randNum = new Random();
		int randID = 1000 + randNum.nextInt(9000);
		System.out.println(randID);
		return randID;
	}
	
	public static Timestamp generateDate() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		return time;
	}
	
//	public static void main (String[] args) {
//		generateID();
//		
//	}


	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}



	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}



	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}



	public String getDescription() {
		return description;
	}

	public void setDescript(String description) {
		this.description = description;
	}



	public String getReciept() {
		return reciept;
	}

	public void setReciept(String reciept) {
		this.reciept = reciept;
	}



	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}



	public int getResolver() {
		return resolver;
	}
	
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	public int getTicketID() {
		return this.TicketID;
	}

	public void setTicketID(int ID) {
//		Random randNum = new Random();
//		 ID = 1000 + randNum.nextInt(9000);
////		System.out.println(ID);
		this.TicketID = ID;
	}



	
	


}
