package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DAOimpl.UserDAOImpl;
import com.jdbc.dao.UserDAO;
import com.jdbc.model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/AddUser")
public class RegisterUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		User u=new User(username,email,password,address,role);
		UserDAO udaoi=new UserDAOImpl();
		int z=udaoi.insertUser(u);
		if(z==0) {
			resp.sendRedirect("failure.html");
		}
		else {
			resp.sendRedirect("sucess.html");
		}
	}
}
