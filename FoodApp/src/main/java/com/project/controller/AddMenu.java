package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DAOimpl.MenuDAOImpl;
import com.jdbc.dao.MenuDAO;
import com.jdbc.model.Menu;

/**
 * Servlet implementation class AddMenu
 */
@WebServlet("/addMenu")
public class AddMenu extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurant_id=Integer.parseInt(req.getParameter("restaurant_id"));
		String item_name=req.getParameter("item_name");
		String description=req.getParameter("description");
		Double price =Double.parseDouble(req.getParameter("price"));
		Boolean isActive=Boolean.parseBoolean(req.getParameter("isActive"));
		String imgpath=req.getParameter("imgpath");
		
		
		Menu m=new Menu(restaurant_id,item_name,description,price,isActive,imgpath);
		MenuDAO mdaoi=new MenuDAOImpl();
		int z=mdaoi.insertMenu(m);
		if(z==0) {
			resp.sendRedirect("failure.html");
		}
		else {	
				resp.sendRedirect("sucess.html");
			
		}
		
	}

}
