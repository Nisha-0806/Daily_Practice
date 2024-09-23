package com.jdbc.Main;

import java.util.ArrayList;

import com.jdbc.DAOimpl.UserDAOImpl;
import com.jdbc.dao.UserDAO;
import com.jdbc.model.User;

public class Main {

	public static void main(String[] args) {
		//insert
		User u=new User("Arun","arun456","arun@gmail.com","Chennai","Customer");
		//interface and its implementing class
		UserDAO uado=new UserDAOImpl();
		uado.insertUser(u);
		//fetchAll
		ArrayList<User>al=(ArrayList<User>)uado.getAllUser();
		for(User us:al) {
			System.out.println(us);
		}
		//fetch specific
		User user=uado.getUserById(1);
		System.out.println(user);
		//delete
		/*int status=uado.deleteUser(1);
		System.out.println(status);
		//update
		int status_Update=uado.updateUser(1,"chickpete , Banglore");
		System.out.println(status_Update);*/
		

	}

}
