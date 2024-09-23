package com.jdbc.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.UserDAO;
import com.jdbc.model.User;

public class UserDAOImpl implements UserDAO{
	User user;
	int x=-1;
	static PreparedStatement pstmt;
	static Connection con;
	static Statement stmt;
	static ResultSet res;
	ArrayList<User> ul=new ArrayList<>();
	
	static private String url="jdbc:mysql://localhost:3306/Online_Food_App";
	static private String username="root";
	static private String pwd="Nisha*123";
	
	final static private String INSERT="insert into user(username,pwd,email,address,role)values(?,?,?,?,?)";
	static final String UPDATE="update `user` set `address`=? where `user_id`=?";
	static String fetch_specific="select * from user where user_id=?";
	static String fetchAll="select * from `user`";
	static final  String DELETE="delete from user where user_id=?";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public int insertUser(User u) {
		 try {
			 pstmt=con.prepareStatement(INSERT); 
			 pstmt.setString(1,u.getUsername());
			 pstmt.setString(2,u.getPwd());
			 pstmt.setString(3,u.getEmail());
			 pstmt.setString(4,u.getAddress());
			 pstmt.setString(5,u.getRole());
			 x=pstmt.executeUpdate();
		 }
		 catch(Exception  e) {
			 e.printStackTrace();
		 }
		return x;
	}
	
	@Override
	public List<User> getAllUser() {
		try {
			stmt=con.createStatement(); 
			res=stmt.executeQuery(fetchAll);
			
			ul=(ArrayList<User>)extractUserListFromResultSet(res);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ul;
	}
	@Override
	public User getUserById(int id) {
		try {
			pstmt=con.prepareStatement(fetch_specific); 
			 pstmt.setInt(1,id);
			res= pstmt.executeQuery();
			ul=(ArrayList<User>)extractUserListFromResultSet(res);
			user=ul.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	

	@Override
	public int deleteUser(int id) {
		try {
			pstmt=con.prepareStatement(fetch_specific); 
			 pstmt.setInt(1,id);
			 x= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}
	@Override
	public int updateUser(int id, String address) {
		try {
			pstmt=con.prepareStatement(fetch_specific); 
			 pstmt.setInt(2,id);
			 pstmt.setString(1, address);
			 x= pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}
	
	private ArrayList<User> extractUserListFromResultSet(ResultSet res) {
		try {
			while(res.next()) {
				ul.add(new User(res.getInt(1),res.getString(2),res.getString(3),
						res.getString(4),res.getString(5),res.getString(6)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ul;
	}
	
	
}
