package com.jdbc.Main;

import java.util.ArrayList;

import com.jdbc.DAOimpl.RestaurantDAOImpl;
import com.jdbc.dao.RestaurantDAO;
import com.jdbc.model.Restaurant;

public class Main_Restaurant {
	    public static void main(String[] args) {
	        // Insert a new restaurant
	        Restaurant newRestaurant = new Restaurant("Star Biryani", "Indain", 30, true, 4, "biryani.jpg");
	        
	        // Interface and its implementing class
	        RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
	        restaurantDAO.insertRestaurant(newRestaurant);
	        
	        // Fetch all restaurants
	        ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) restaurantDAO.getAllRest();
	        for (Restaurant restaurant : restaurantList) {
	            System.out.println(restaurant);
	        }
	        
	        // Fetch a specific restaurant by ID
	        Restaurant specificRestaurant = restaurantDAO.getRestById(1);  // Fetching the restaurant with ID = 1
	        System.out.println(specificRestaurant);


	        // Delete a restaurant by ID
	        /*
	        int deleteStatus = restaurantDAO.deleteResById(1);  // Deleting the restaurant with ID = 1
	        System.out.println("Delete Status: " + deleteStatus);
	        */
	        
	        // Update the isActive status of a restaurant by ID
	        /*
	        int updateStatus = restaurantDAO.updateResById(1, false);  // Updating is_active status for restaurant with ID = 1
	        System.out.println("Update Status: " + updateStatus);
	        */
	    }
	}



