package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.DAOimpl.RestaurantDAOImpl;
import com.jdbc.dao.RestaurantDAO;
import com.jdbc.model.Restaurant;
@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	private HttpSession sess;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAO r=new RestaurantDAOImpl();
		List<Restaurant>resList=(List<Restaurant>) r.getAllRest();
		sess=req.getSession();
		sess.setAttribute("resList", resList);
		resp.sendRedirect("home.jsp");
	}

}
