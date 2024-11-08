package com.jdbc.model;

public class Order_item {
	private int orderitem_id;
	private int order_id;
	private int menu_id;
	private int quantity;
	private int sub_total;
	public int getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(int orderitem_id) {
		this.orderitem_id = orderitem_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSub_total() {
		return sub_total;
	}
	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}
	public Order_item(int orderitem_id, int order_id, int menu_id, int quantity, int sub_total) {
		super();
		this.orderitem_id = orderitem_id;
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.sub_total = sub_total;
	}
	public Order_item(int order_id, int menu_id, int quantity, int sub_total) {
		super();
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.sub_total = sub_total;
	}
	@Override
	public String toString() {
		return "Order_item [orderitem_id=" + orderitem_id + ", order_id=" + order_id + ", menu_id=" + menu_id
				+ ", quantity=" + quantity + ", sub_total=" + sub_total + "]";
	}

}
