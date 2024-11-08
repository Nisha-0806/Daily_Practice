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

import com.details.Employee;

/**
 * Servlet implementation class EditEmployee
 */
public class EditEmployee extends HttpServlet {
	private Connection con;
	private Statement stmt;
	private String fetchOnID="select*from employee where empid=?";
	private PreparedStatement pstmt;
	private ResultSet res;
	private HttpSession sess;
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
		try {
			sess=req.getSession();
			int id=Integer.parseInt(req.getParameter("id"));
			pstmt=con.prepareStatement(fetchOnID);
			pstmt.setInt(1, id);
			
			res=pstmt.executeQuery();
			if(res.next()) {
			Employee e=new Employee(res.getInt(1),res.getString(2),res.getString("desig"),res.getInt("salary"),
						res.getString("email"),res.getString("password"));
			sess.setAttribute("e", e);
				resp.sendRedirect("editEmployee.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
