package com.project01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class ViewAccount
 */
public class ViewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginDAO logDAO = new LoginDAO();
		System.out.println("Inside View Account");
		HttpSession session = request.getSession();

		User u = new User();
		String user = request.getSession().getAttribute("author").toString();
		String pass = request.getSession().getAttribute("pass").toString();

//		u = logDAO.currUser(user, pass);

		System.out.println("Username: " + user);
		System.out.println("Password: " + pass);

		PrintWriter out = response.getWriter();

		try {

			//Employee logging in
			u = logDAO.currUser(user, pass);
			System.out.println("Employee Login Success");
			System.out.println("Account Username: " + u.getUsername());
			System.out.println("Account Password: " + u.getPassword());
			System.out.println("Account User ID: " + u.getUserID());
			System.out.println("Account First Name: " + u.getFirstname());
			System.out.println("Account Last Name: " + u.getLastname());
			System.out.println("Account Email: " + u.getEmail());
			System.out.println("Account Phone Number: " + u.getPhoneNum());
			
			String accountInfo = new Gson().toJson(u);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			out.print(accountInfo);
			out.flush();
			System.out.println("Account Information" + accountInfo);			

//			if(u.getUserID() == 0 ) {
//				System.out.println("Employee Login Success");
//				System.out.println("Account Username: " + u.getUsername());
//				System.out.println("Account Password: " + u.getPassword());
//				System.out.println("Account User ID: " + u.getUserID());
//				System.out.println("Account First Name: " + u.getFirstname());
//				System.out.println("Account Last Name: " + u.getLastname());
//				System.out.println("Account Email: " + u.getEmail());
//				System.out.println("Account Phone Number: " + u.getPhoneNum());
//				
//			
//				System.out.println(u.getUsername() + " Signed In");
//			}
//			//Manager logging in
//			else if(u.getUserID() == 1 ) {
//				System.out.println("Manager Login Success");
//				System.out.println("Employee Login Success");
//				System.out.println("Account Username: " + u.getUsername());
//				System.out.println("Account Password: " + u.getPassword());
//				System.out.println("Account User ID: " + u.getUserID());
//				System.out.println("Account First Name: " + u.getFirstname());
//				System.out.println("Account Last Name: " + u.getLastname());
//				System.out.println("Account Email: " + u.getEmail());
//				System.out.println("Account Phone Number: " + u.getPhoneNum());
//				//				session.setAttribute("author", u.getUsername());
//				System.out.println(u.getUsername() + " Signed In");
//
//			}
//			else {
//				System.out.println("Wrong username/password: FROM SERVLET");
//
//				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}





/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
