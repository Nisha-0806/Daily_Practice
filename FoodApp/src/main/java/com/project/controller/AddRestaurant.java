package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.DAOimpl.RestaurantDAOImpl;
import com.jdbc.dao.RestaurantDAO;
import com.jdbc.model.Restaurant;

/**
 * Servlet implementation class AddRestaurant
 */
@WebServlet("/AddRestaurant")
public class AddRestaurant extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurant_id=Integer.parseInt(req.getParameter("restaurant_id"));
		String name=req.getParameter("name");
		String cuisine_type=req.getParameter("cuisine_type");
		int delivery_time=Integer.parseInt(req.getParameter("delivery_time"));
		Boolean is_active=Boolean.parseBoolean(req.getParameter("is_active"));
		int ratings=Integer.parseInt(req.getParameter("ratings"));
		String img_path=req.getParameter("img_path");
		
		Restaurant r =new Restaurant(name,cuisine_type,delivery_time,is_active,ratings,img_path);
		RestaurantDAO rdaoi=new RestaurantDAOImpl();
		int z=rdaoi.insertRestaurant(r);
		if(z==0) {
			resp.sendRedirect("failure.html");
		}
		else {
			resp.sendRedirect("sucess.html");
		}
	}

}
