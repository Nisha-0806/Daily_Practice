package com.hiber.main;

import com.hp.entity.Employee;
import com.hp.manager.HibernateManager;

public class EmployeeMain {

	public static void main(String[] args) {
		HibernateManager hm=new HibernateManager();
		hm.connect();
		
//		Employee e=new Employee(7,"Akhill","Developerr",500000,"ak@gmail.com","ASD");
//		hm.add(e);
		//hm.fetchAll();
		//hm.fetchspecific(6);
//hm.fetchOnEmail("aj@gmail.com");
		hm.update(5, "akhil@yahoo.co.in");
		//hm.delete(5);
	}

}
