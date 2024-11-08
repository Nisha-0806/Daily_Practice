package com.operations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteEmp
 */
public class DeleteEmp extends HttpServlet {
	private Connection con;
	private String Delete="delete from employee where empid=?";
	private PreparedStatement pstmt;
	private ResultSet res;
	private HttpSession sess;
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdb","root","Nisha*123");
			 pstmt=con.prepareStatement(Delete);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("empid"));
		
		try {
			pstmt.setInt(1,id);
		int z=	pstmt.executeUpdate();
		if(z==0) {
			resp.sendRedirect("failure.jsp");
		}
		else {
			resp.sendRedirect("FetchAll");
		}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
