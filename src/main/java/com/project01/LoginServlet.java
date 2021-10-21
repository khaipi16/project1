package com.project01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private loginDAO logDAO;


	//	   public void init() {
	//	    	logDAO = new loginDAO();
	//	   }

	/**
	 * Default constructor. 
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	
	//request == goes from js to servlet
	//response == goes from servlet to js
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu

		LoginDAO logDAO = new LoginDAO();
		System.out.println("Inside servlet");

		System.out.println("This prints out the request" + request);
		String jsonS = request.getReader().readLine();
		System.out.println("this is jsonsS " + jsonS);
		ObjectMapper obj = new ObjectMapper();

		User u = obj.readValue(jsonS, User.class);
		System.out.println("Username: " + u.getUsername());
		System.out.println("Password: " + u.getPassword());
		String user = u.getUsername();
		//		String pass = u.getPassword();
		System.out.println("User ID: " + u.getUserID());
		//		System.out.println("First Name: " + u.getFirstname());
		//		System.out.println("Last Name: " + u.getLastname());
		//		System.out.println("Email: " + u.getEmail());
		//		System.out.println("Phone Number: " + u.getFirstname());
		//		User user = new User();
		//		user = logDAO.validate(user);

		//		//setting the request type to be text/html
		//		response.setContentType("text/html");
		//		
		//		//return writer
		//		PrintWriter out = response.getWriter();

		//RequestDispatcher dispatcher = getRequestDispatcher("ReimEmpPage.html");
	
		try {
			//			String loginPage = "loginPage.html";
			//response.sendRedirect("ReimEmpPage.html");
//			PrintWriter out = response.getWriter();

			//Employee logging in
			u = logDAO.currUser(u.getUsername(), u.getPassword());
//			System.out.println("User ID 2: " + u.getUserID());
			if(u.getUserID() == 0 ) {
				System.out.println("Employee Login Success");
				System.out.println("Servlet Username: " + u.getUsername());
				System.out.println("Servlet Password: " + u.getPassword());
				System.out.println("Servlet User ID: " + u.getUserID());
				System.out.println("Servlet First Name: " + u.getFirstname());
				System.out.println("Servlet Last Name: " + u.getLastname());
				System.out.println("Servlet Email: " + u.getEmail());
				System.out.println("Servlet Phone Number: " + u.getPhoneNum());


				HttpSession session = request.getSession();
//				out.println("Welcome, " + u.getUsername());

				session.setAttribute("author", u.getUsername());
				session.setAttribute("pass", u.getPassword());

				System.out.println(u.getUsername() + " Signed In");
				//loginPage = "ReimEmpPage.html";
				response.sendRedirect("/Project01/employeeHome.html");

			}
			//Manager logging in
			else if(u.getUserID() == 1 ) {
				System.out.println("Manager Login Success");
				System.out.println("Employee Login Success");
				System.out.println("Servlet Username: " + u.getUsername());
				System.out.println("Servlet Password: " + u.getPassword());
				System.out.println("Servlet User ID: " + u.getUserID());
				System.out.println("Servlet First Name: " + u.getFirstname());
				System.out.println("Servlet Last Name: " + u.getLastname());
				System.out.println("Servlet Email: " + u.getEmail());
				System.out.println("Servlet Phone Number: " + u.getPhoneNum());
				HttpSession session = request.getSession(true);
//				session.setAttribute("author", u.getUsername());
				session.setAttribute("author", u.getUsername());
				session.setAttribute("pass", u.getPassword());
				System.out.println(u.getUsername() + " Signed In");


				//				session.setAttribute(jsonS, u);
				//loginPage = "ReimEmpPage.html";
				response.sendRedirect("/Project01/managerHome.html");
			}
			else {
				System.out.println("Wrong username/password: FROM SERVLET");

				//String errorMessage = "Invalid username/password";
				//request.setAttribute("message", errorMessage);
				//out.print("Incorrect username/password");
//				response.sendError(0, "Wrong");
//				request.getRequestDispatcher("loginPage.html").include(request, response);
//				response.getWriter().append("Failed");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//		String username = request.getParameter("username");
		//		String password = request.getParameter("password");
		//		
		//		u.setUsername(username);
		//		u.setPassowrd(password);
		//		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//		
		//		
		//        response.setContentType("text/plain");
		//        try {
		//            loginInfo user = ob.readValue(request.getReader(), loginInfo.class);
		//            //do something with your object
		//        } catch (InvalidFormatException e) {
		//            
		//        }
		//        response.getWriter().append("String to send back");
		//			
	}

	//	private RequestDispatcher getRequestDispatcher(String string) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}





