package com.project01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PendingServlet
 */
public class PendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String bracket = request.getParameter("bracket"); 
		    String from = request.getParameter("FromSalary");
		    String to = request.getParameter("ToSalary"); 
		    String rate = request.getParameter("rate"); 
		    
		    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_system", "root", ""); 
	         PreparedStatement ps = con.prepareStatement("INSERT INTO payroll_system.tax_info(TaxBracket, FromSalary, ToSalary, TaxPercentage) values(?,?,?,?)"); 
	         ps.setString(1, bracket);
	         ps.setString(2, from);
	         ps.setString(3, to);
	         ps.setString(4, rate);

	         int count = ps.executeUpdate(); 
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
