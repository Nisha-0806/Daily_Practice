package com.jdbc.model;

public class Restaurant {
	private int restaurant_id;
	private String name;
	private String cuisine_type;
	private int delivery_time;
	private Boolean isActive;
	private int ratings;
	private String imgpath;
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine_type() {
		return cuisine_type;
	}
	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}
	public int getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(int delivery_time) {
		this.delivery_time = delivery_time;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Restaurant(int restaurant_id, String name, String cuisine_type, int delivery_time, Boolean isActive,
			int ratings, String imgpath) {
		super();
		this.restaurant_id = restaurant_id;
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imgpath = imgpath;
	}
	public Restaurant(String name, String cuisine_type, int delivery_time, Boolean isActive, int ratings,
			String imgpath) {
		super();
		this.name = name;
		this.cuisine_type = cuisine_type;
		this.delivery_time = delivery_time;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imgpath = imgpath;
	}
	public Restaurant() {
		
	}
	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", name=" + name + ", cuisine_type=" + cuisine_type
				+ ", delivery_time=" + delivery_time + ", isActive=" + isActive + ", ratings=" + ratings + ", imgpath="
				+ imgpath + "]";
	}
	

}
