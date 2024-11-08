package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	int empid,salary;
	String password,desig,empname;
	private static Connection con;
	String validate="select * from employee where email=?";
	private ResultSet res;
	private RequestDispatcher rd;
	private HttpSession ses;
	private static PreparedStatement psmt;
	@Override
	public void init() throws ServletException {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Nisha*123");
			psmt=con.prepareStatement(validate);
		} catch (Exception e) {
			throw new ServletException("Database connection problem", e);
		}
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			psmt.setString(1, "email");
			res=psmt.executeQuery();
			if(res.next()) {
				if(password.equals(res.getString("password"))) {
					
					empid=res.getInt("empid");
					empname=res.getString("empname");
					this.password=res.getString("password");
					desig=res.getString("desig");
					email=res.getString("email");
					salary=res.getInt("salary");
					//session 
	 			    ses=req.getSession();
	 			    ses.setAttribute("empname",empname);
	 			    ses.setAttribute("empid",empid);
	 			    
					rd=req.getRequestDispatcher("dispServlet");
					rd.forward(req, resp);
					//resp.sendRedirect("valid.html");
				}
				else {
					resp.sendRedirect("invalid.html");
				}
				
			}
			else {
				resp.sendRedirect("register.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
