package com.jdbc.dao;

import java.util.List;

import com.jdbc.model.User;

public interface  UserDAO {
	int insertUser(User u);
	List<User> getAllUser();
	User getUserByEmail(String email);
	int deleteUser(int id);
	int updateUser(String email,String pwd);

}
