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
	static final String UPDATE="update `user` set `pwd`=? where `email`=?";
	static String fetch_specific="select * from user where email=?";
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
	public User getUserByEmail(String email) {
		try {
			pstmt=con.prepareStatement(fetch_specific); 
			 pstmt.setString(1,email);
			res= pstmt.executeQuery();
//			ul=(ArrayList<User>)extractUserListFromResultSet(res);
//			user=ul.get(0);
			while(res.next()) {
				user=new User(res.getString("username"),res.getString("pwd"),res.getString("email"),
						res.getString("address"));
			}
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
	public int updateUser(String email, String pwd) {
		try {
			pstmt=con.prepareStatement(fetch_specific); 
			 pstmt.setString(2,email);
			 pstmt.setString(1, pwd);
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
