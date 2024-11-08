package com.hp.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hp.entity.Employee;

public class HibernateManager {
	private static Configuration config;
	private static SessionFactory sf;
	private static Session sess;
	private Transaction trans;
	static List<Employee> empli;


	public void connect() {
		config=new Configuration();
		config=config.configure().addAnnotatedClass(Employee.class);
		sf=config.buildSessionFactory();
		sess=sf.openSession();
		trans=sess.beginTransaction();
		
	}
	public void add(Employee e) {
		sess.persist(e);
		trans.commit();
		
	}
	public void fetchAll() {
		empli=sess.createQuery("from Employee").list();
		for(Employee e:empli) {
			System.out.println(e);
		}
		
	}
	public void fetchspecific(int id) {
		Employee e=(Employee) sess.get(Employee.class,id);
		System.out.println(e);
	}
	public void fetchOnEmail(String email) {
		empli=sess.createQuery("from Employee where email='"+email+"'").list();
		for(Employee e:empli) {
			System.out.println(e);
		}
	}
	public void update(int id,String email) {
		Employee e=sess.get(Employee.class,id);
		if(e!=null) {
			e.setEmail(email);
			sess.persist(e);
			trans.commit();
		}
		else {
			System.out.println("No records found");
		}
	}
	public void delete(int id){
		Employee e=sess.get(Employee.class,id);
		if(e!=null) {
			sess.delete(e);
			trans.commit();
		}
		else {
			System.out.println("No such record");
		}
	}
	
}


