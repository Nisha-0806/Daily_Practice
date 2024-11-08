package com.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.details.Employee;

/**
 * Servlet implementation class EditData
 */
public class EditData extends HttpServlet {
	static Connection con;
	static Statement stmt;
	static PreparedStatement pstmt;
	private String update="update employee set desig=?,salary=?,password=?,where empid=?";
	private HttpSession sess;
	@Override
		public void init() throws ServletException {
		try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Nisha*123");
			   
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			pstmt=con.prepareStatement(update);
			pstmt.setString(1,req.getParameter("desig"));
			pstmt.setString(2,req.getParameter("salary"));
			pstmt.setString(3,req.getParameter("password"));
			Employee e=	(Employee)sess.getAttribute("e");
			int id=e.getEmpid();
			pstmt.setInt(4,id);
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
