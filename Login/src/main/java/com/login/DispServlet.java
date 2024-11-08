package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DispServlet
 */
@WebServlet("/dispServlet")
public class DispServlet extends HttpServlet {
	private PrintWriter pw;
	private HttpSession ses;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			pw=resp.getWriter();
			
			ses= req.getSession();
			String empname=(String) ses.getAttribute("empname");
			//pw.println("welcome "+req.getParameter("empname")+"!!!!");
			pw.println("welcome "+empname+"!!!"); 
	}
	
       
    
}
