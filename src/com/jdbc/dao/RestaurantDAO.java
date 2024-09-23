package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.Restaurant;

public interface RestaurantDAO {
	int insertRestaurant(Restaurant res);
	List<Restaurant>getAllRest();
	Restaurant getRestById(int id);
	int deleteResById(int id);
	int updateResById(int id,boolean isActive);

}
