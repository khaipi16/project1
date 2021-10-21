package com.project01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchTicketServlet
 */
public class SearchTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String user = session.getAttribute("author").toString();
		System.out.println("User is:" + user);
		
		TicketDAO t = new TicketDAO();
		ArrayList<Ticket> tickets = t.getAllTicketsByUser(user);
		String ticketsByUser = new Gson().toJson(tickets);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("Tickets for " + user + ticketsByUser);
		
		out.print(ticketsByUser);
		out.flush();
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
