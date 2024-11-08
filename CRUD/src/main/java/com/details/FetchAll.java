package com.details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FetchAll extends HttpServlet {
	private Connection con;
	private Statement stmt;
private String query="select * from employee";
private ResultSet res;
ArrayList<Employee>empli=new ArrayList<>();
private HttpSession sess;
private static PrintWriter pw;
	@Override
	public void init() throws ServletException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Nisha*123");
				 stmt=con.createStatement();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw=resp.getWriter();
		try {
			res=stmt.executeQuery(query);
			empli.clear();
			while(res.next()) {
				empli.add(new Employee(res.getInt("empid"),
				res.getString("empname"),
				res.getString("desig"),
				res.getInt("salary"),
				res.getString("email"),
				res.getString("password")));
			}
			sess=req.getSession();
			sess.setAttribute("empli", empli);
			resp.sendRedirect("DispEmp.jsp");
		}
			

		/*	pw.println("<html><body><center>");
			pw.println("<h1>Employee Details</h1>");
			pw = resp.getWriter();
			    // Begin the HTML table structure
			    pw.println("<table border='1'>");
			    pw.println("<tr>");
			    pw.println("<th>Emp ID</th>");
			    pw.println("<th>Emp Name</th>");
			    pw.println("<th>Designation</th>");
			    pw.println("<th>Email</th>");
			    pw.println("<th>Password</th>");
			    pw.println("</tr>");

			    // Query execution and displaying results in table rows
			    res = stmt.executeQuery(query);
			    while (res.next()) {
			        pw.println("<tr>");
			        pw.println("<td>" + res.getInt("empid") + "</td>");
			        pw.println("<td>" + res.getString("empname") + "</td>");
			        pw.println("<td>" + res.getString("desig") + "</td>");
			        pw.println("<td>" + res.getString("email") + "</td>");
			        pw.println("<td>" + res.getString("password") + "</td>");
			        pw.println("</tr>");
			    }

			    // End the table structure
			    pw.println("</table>");
			    pw.println("</center></body></head>");
			} */
			catch (Exception e) {
			    e.printStackTrace();
			} 
	}
}

