package com.empdetails;

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
 * Servlet implementation class InsertEmployee
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private Connection con;
	String query="insert into employee(emp_id,emp_name,desig,salary)values(?,?,?,?)";
	private PreparedStatement psmt;
	@Override
		public void init() throws ServletException {
			try {
				Class.forName("com.mysql.cj.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Nisha*123");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			psmt=con.prepareStatement(query);
			int empid=Integer.parseInt(req.getParameter("empid"));
			String empname=req.getParameter("empname");
			String desig=req.getParameter("desig");
			int salary=Integer.parseInt(req.getParameter("salary"));
			
			psmt.setInt(1, empid);
			psmt.setString(2, empname);
			psmt.setString(3, desig);
			psmt.setInt(4,salary);
			
			int status=psmt.executeUpdate();
			if(status==0) {
				resp.sendRedirect("failure.html");
			}
			else {
				resp.sendRedirect("sucess.html");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
