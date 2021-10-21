package com.project01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * Servlet implementation class TicketServlet
 */
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String userA = "admin";
	private static final String password = "12345678";
	private static final String db_url = "jdbc:oracle:thin:@database-1.czjydg612bvc.us-east-2.rds.amazonaws.com:1521:ORCL";
	private String aut;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside ticket servlet");
		TicketDAO ticketDAO = new TicketDAO();

		
		HttpSession session = request.getSession();
		session.getAttribute("author");
		System.out.println("Author is: " + session.getAttribute("author"));

		//inserting new tickets submitted from HTML page
		String jsonTicket = request.getReader().readLine();
		System.out.println("JSON Ticket " + jsonTicket);
		ObjectMapper objTicket = new ObjectMapper();
		Ticket newTicket = objTicket.readValue(jsonTicket, Ticket.class);
		newTicket.setAuthor((String)session.getAttribute("author"));
		ticketDAO.insertTicket(newTicket);
		
	
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



	public void viewAllTickets(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{  

	}  
} 

