package com.oper.main;

import com.hibernate.entity.Student;
import com.hibernate.manger.HibernateManager;

public class Stu_Main {

	public static void main(String[] args) {
		HibernateManager hm=new HibernateManager();
		
		hm.connect();
		Student s=new Student("Nisha","nish@yahoo.com","9894259533");
		hm.insert(s);

	}

}
