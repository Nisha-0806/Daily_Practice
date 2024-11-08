package com.jdbc.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.RestaurantDAO;
import com.jdbc.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO {
	Restaurant restaurant;
	int x=-1;
	static PreparedStatement pstmt;
	static Connection con;
	static Statement stmt;
	static ResultSet res;
	List<Restaurant>restaurantList =new ArrayList<>();
	
	// Database connection parameters
	static private String url="jdbc:mysql://localhost:3306/Online_Food_App";
	static private String username="root";
	static private String pwd="Nisha*123";
	
	 // SQL queries
	final static private String INSERT = "INSERT INTO restaurants (name, cuisine_type, delivery_time, isactive, ratings, img_path) VALUES (?, ?, ?, ?, ?, ?)";
    static final String UPDATE = "UPDATE restaurants SET isactive = ? WHERE restaurant_id = ?";
    static String fetch_specific = "SELECT * FROM restaurants WHERE restaurant_id = ?";
    static String fetchAll = "SELECT * FROM restaurants";
    static final String DELETE = "DELETE FROM restaurants WHERE restaurant_id = ?";
    
 // Static block to load the JDBC driver and connect to the database
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Insert a new restaurant into the database
	@Override
	public int insertRestaurant(Restaurant res) {
		 try {
	            pstmt = con.prepareStatement(INSERT);
	            pstmt.setString(1, res.getName());
	            pstmt.setString(2, res.getCuisine_type());
	            pstmt.setInt(3, res.getDelivery_time());
	            pstmt.setBoolean(4, res.getIsActive());
	            pstmt.setInt(5, res.getRatings());
	            pstmt.setString(6, res.getImgpath());

	            x = pstmt.executeUpdate();
	        } 
		  catch (Exception e) {
	            e.printStackTrace();
	        }
	        return x;
	}
	
	 // Fetch all restaurants from the database
	@Override
	public List<Restaurant> getAllRest() {
		 try {
	            stmt = con.createStatement();
	            res = stmt.executeQuery(fetchAll);
	            restaurantList = (ArrayList<Restaurant>) extractRestaurantListFromResultSet(res);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return restaurantList;

	}
	
	  // Fetch a specific restaurant by its ID
	@Override
	public Restaurant getRestById(int id) {
		try {
            pstmt = con.prepareStatement(fetch_specific);
            pstmt.setInt(1, id);
            res = pstmt.executeQuery();
            restaurantList = (ArrayList<Restaurant>) extractRestaurantListFromResultSet(res);
            if (!restaurantList.isEmpty()) {
                restaurant = restaurantList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;

	}
	
	// Update the isActive field of a specific restaurant by its ID
	@Override
	public int updateResById(int id, boolean isActive) {
		try {
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setBoolean(1, isActive);
            pstmt.setInt(2, id);
            x = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;

	}
	
	// Delete a restaurant by its ID
	@Override
	public int deleteResById(int id) {
		 try {
	            pstmt = con.prepareStatement(DELETE);
	            pstmt.setInt(1, id);
	            x = pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return x;
	}
	 // Helper method to extract a list of restaurants from a ResultSet
    private ArrayList<Restaurant> extractRestaurantListFromResultSet(ResultSet res)
    {
        ArrayList<Restaurant> list = new ArrayList<>();
        try {
            while (res.next()) {
                list.add(new Restaurant(
                        res.getInt("restaurant_id"),
                        res.getString("name"),
                        res.getString("cuisine_type"),
                        res.getInt("delivery_time"),
                        res.getBoolean("isactive"),
                        res.getInt("ratings"),
                        res.getString("img_path")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	

}
