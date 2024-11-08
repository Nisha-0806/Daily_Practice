package com.jdbc.model;

public class OrderHistory {
	private int oh_id;
	private int user_id;
	private int order_id;
	private int total;
	private String status;
	public OrderHistory(int oh_id, int user_id, int order_id, int total, String status) {
		super();
		this.oh_id = oh_id;
		this.user_id = user_id;
		this.order_id = order_id;
		this.total = total;
		this.status = status;
	}
	public int getOh_id() {
		return oh_id;
	}
	public void setOh_id(int oh_id) {
		this.oh_id = oh_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderHistory(int user_id, int order_id, int total, String status) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.total = total;
		this.status = status;
	}
	public OrderHistory() {
		super();
	}
	@Override
	public String toString() {
		return "OrderHistory [oh_id=" + oh_id + ", user_id=" + user_id + ", order_id=" + order_id + ", total=" + total
				+ ", status=" + status + "]";
	}
	

}
