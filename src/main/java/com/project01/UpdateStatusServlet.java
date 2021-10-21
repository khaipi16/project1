package com.project01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UpdateStatusServlet
 */
@JsonIgnoreProperties
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String jsonS = request.getReader().readLine();
		System.out.println("below is JSON");
		System.out.println(jsonS);
		String[] myStatus = jsonS.split(",");
		System.out.println(myStatus[0]);
		

		ObjectMapper obj = new ObjectMapper();
		obj.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		TicketDAO updateTickets = new TicketDAO();
//		Ticket t = obj.readValue(jsonS, Ticket.class);
//		System.out.println("Ticket ID: " + t.getTicketID());
//		System.out.println("Ticket author: " + t.getAuthor());
//		System.out.println("Ticket type: " + t.getType());
//		System.out.println("Ticket amount: " + t.getAmount());
//		System.out.println("Ticket description: " + t.getDescription());
//		System.out.println("Ticket submitted: " + t.getSubmitted());
//		System.out.println("Ticket Status: " + t.getStatus());
		
		System.out.println("Author: " + request.getSession().getAttribute("author").toString());


		
		updateTickets.updateStatus(Integer.parseInt(myStatus[0]), myStatus[1], request.getSession().getAttribute("author").toString());

				
//		String updatedTickets = currTickets.updateStatus(t.getTicketID(), t.getStatus(), request.getSession().getAttribute("author").toString());	
		
	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
