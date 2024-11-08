package com.jdbc.model;

public class Orders {
	private int order_id;
	private int user_id;
	private int restaurant_id;
	private int total_amount;
	private String status;
	private String payment_mode;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public Orders(int order_id, int user_id, int restaurant_id, int total_amount, String status, String payment_mode) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment_mode = payment_mode;
	}
	public Orders(int user_id, int restaurant_id, int total_amount, String status, String payment_mode) {
		super();
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.total_amount = total_amount;
		this.status = status;
		this.payment_mode = payment_mode;
	}
	public Orders() {
		super();
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", user_id=" + user_id + ", restaurant_id=" + restaurant_id
				+ ", total_amount=" + total_amount + ", status=" + status + ", payment_mode=" + payment_mode + "]";
	}

}
