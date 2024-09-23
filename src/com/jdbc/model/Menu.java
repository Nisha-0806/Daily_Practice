package com.jdbc.model;

public class Menu {
	private int menu_id;
	private int res_id;
	private String item_name;
	private String desc;
	private Double price;
	private Boolean isavail;
	private String img_path;
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIsavail() {
		return isavail;
	}
	public void setIsavail(Boolean isavail) {
		this.isavail = isavail;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Menu(int menu_id, int res_id, String item_name, String desc, Double price, Boolean isavail,
			String img_path) {
		super();
		this.menu_id = menu_id;
		this.res_id = res_id;
		this.item_name = item_name;
		this.desc = desc;
		this.price = price;
		this.isavail = isavail;
		this.img_path = img_path;
	}
	public Menu(int res_id, String item_name, String desc, Double price, Boolean isavail, String img_path) {
		super();
		this.res_id = res_id;
		this.item_name = item_name;
		this.desc = desc;
		this.price = price;
		this.isavail = isavail;
		this.img_path = img_path;
	}
	public Menu() {
		
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", res_id=" + res_id + ", item_name=" + item_name + ", desc=" + desc
				+ ", price=" + price + ", isavail=" + isavail + ", img_path=" + img_path + "]";
	}
	
	
}
