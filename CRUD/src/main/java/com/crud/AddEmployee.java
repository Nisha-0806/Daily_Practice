package com.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet {
	private Connection con;
	private PreparedStatement pstmt;
	private final String INSERT="insert into employee(empname,desig,salary,email,password) values (?,?,?,?,?)";

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Nisha*123");
			 pstmt=con.prepareStatement("INSERT");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				pstmt.setString(1,req.getParameter("empname"));
				pstmt.setString(2,req.getParameter("desig"));
				pstmt.setInt(3,Integer.parseInt(req.getParameter("salary")));
				pstmt.setString(4,req.getParameter("email"));
				pstmt.setString(5,req.getParameter("password"));
				
				int z=pstmt.executeUpdate();
				if(z!=0) {
					resp.sendRedirect("FetchAll");
				}
				else {
					resp.sendRedirect("failure.html");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

}
