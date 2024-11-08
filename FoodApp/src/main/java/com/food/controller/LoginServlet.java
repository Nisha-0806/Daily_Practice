package com.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DAOimpl.UserDAOImpl;
import com.jdbc.dao.UserDAO;
import com.jdbc.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private HttpSession sess;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		//System.out.println(pwd);
		
		UserDAO udao=new UserDAOImpl();
		User user=udao.getUserByEmail(email);
		//System.out.println(user.getPwd());
		if(user!=null) {
			if(pwd.equals(user.getPwd())) {
				sess=req.getSession();
				//sess.setAttribute("name", user.getUsername());
				sess.setAttribute("user", user);
				//resp.sendRedirect("home.jsp");
				resp.sendRedirect("homeServlet");
			}
			else {
				resp.sendRedirect("pwdMismatch.jsp");
			}
		}
		else {
			resp.sendRedirect("register.jsp");
		}
	}
}
