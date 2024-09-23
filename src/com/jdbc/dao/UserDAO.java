package com.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.User;

public interface UserDAO {
	int insertUser(User u);
	List<User> getAllUser();
	User getUserById(int id);
	int deleteUser(int id);
	int updateUser(int id,String address);

	

}
