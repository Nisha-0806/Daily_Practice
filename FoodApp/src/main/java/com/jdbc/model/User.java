package com.jdbc.model;

public class User {
	private int user_id;
	private String username;
	private String pwd;
	private String email;
	private String address;
	private String role;
	
	public User(int user_id,String username,String pwd,String email,String address,String role ){
		this.user_id=user_id;
		this.username=username;
		this.pwd=pwd;
		this.email=email;
		this.address=address;
		this.role=role;
	}
	public User(String username,String pwd,String email,String address,String role ){
		this.username=username;
		this.pwd=pwd;
		this.email=email;
		this.address=address;
		this.role=role;
	}
	public User(String username, String pwd, String email, String address) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.email = email;
		this.address = address;
	}
	public User(){
		
	}
	 public void setId(int user_id) {
		this.user_id=user_id;
	}
	public int getId() {
		return user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return user_id+"   "+username+"     "+pwd+"     "+email+"     "+address+"      "+role;
	} 


}
