package com.jdbc.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.MenuDAO;
import com.jdbc.model.Menu;

public class MenuDAOImpl implements MenuDAO {
	 static Connection con;
	    static PreparedStatement pstmt;
	    static Statement stmt;
	    static ResultSet res;

	    // Database connection parameters
	    static private String url = "jdbc:mysql://localhost:3306/Online_Food_App";
	    static private String username = "root";
	    static private String pwd = "Nisha*123";

	    // SQL queries
	    final static private String INSERT = "INSERT INTO menu (restaurant_id, item_name, description, price, isavailable, img_path) VALUES (?, ?, ?, ?, ?, ?)";
	    static final String FETCH_ALL = "SELECT * FROM menu WHERE restaurant_id = ?";
	    static final String FETCH_BY_ID = "SELECT * FROM menu WHERE menu_id = ?";
	    static final String DELETE = "DELETE FROM menu WHERE menu_id = ?";
	    static final String UPDATE = "UPDATE menu SET isAvailable = ? WHERE menu_id = ?";

	    // Static block to load the JDBC driver and connect to the database
	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, username, pwd);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // Insert a new menu item into the database
	    @Override
	    public int insertMenu(Menu m) {
	        int result = 0;
	        try {
	            pstmt = con.prepareStatement(INSERT);
	            pstmt.setInt(1, m.getRes_id());
	            pstmt.setString(2, m.getItem_name());
	            pstmt.setString(3, m.getDesc());
	            pstmt.setDouble(4, m.getPrice());
	            pstmt.setBoolean(5, m.getIsavail());
	            pstmt.setString(6, m.getImg_path());

	            result = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    // Fetch all menu items for a specific restaurant
	    @Override
	    public List<Menu> getAllRestMenu(int res_id) {
	        List<Menu> menuList = new ArrayList<>();
	        try {
	            pstmt = con.prepareStatement(FETCH_ALL);
	            pstmt.setInt(1, res_id);
	            res = pstmt.executeQuery();
	            while (res.next()) {
	                menuList.add(new Menu(
	                        res.getInt("menu_id"),
	                        res.getInt("restaurant_id"),
	                        res.getString("item_name"),
	                        res.getString("description"),
	                        res.getDouble("price"),
	                        res.getBoolean("isavailable"),
	                        res.getString("img_path")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menuList;
	    }

	    // Fetch a specific menu item by its ID
	    @Override
	    public Menu getMenuById(int id) {
	        Menu menu = null;
	        try {
	            pstmt = con.prepareStatement(FETCH_BY_ID);
	            pstmt.setInt(1, id);
	            res = pstmt.executeQuery();
	            if (res.next()) {
	                menu = new Menu(
	                        res.getInt("menu_id"),
	                        res.getInt("res_id"),
	                        res.getString("item_name"),
	                        res.getString("description"),
	                        res.getDouble("price"),
	                        res.getBoolean("isavail"),
	                        res.getString("img_path")
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return menu;
	    }

	    // Delete a menu item by its ID
	    @Override
	    public int deleteMenuById(int id) {
	        int result = 0;
	        try {
	            pstmt = con.prepareStatement(DELETE);
	            pstmt.setInt(1, id);
	            result = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }

	    // Update the availability status of a menu item
	    @Override
	    public int UpdateMenuById(String isavail, int id) {
	        int result = 0;
	        try {
	            pstmt = con.prepareStatement(UPDATE);
	            pstmt.setBoolean(1, Boolean.parseBoolean(isavail));
	            pstmt.setInt(2, id);
	            result = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	
}
