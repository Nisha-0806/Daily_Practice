package com.hibernate.manger;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;


public class HibernateManager {
	private static Configuration config;
	List<Student>stuli;
	private Transaction trans;
	private SessionFactory sf;
	private Session sess;
	public void connect() {
		config=new Configuration().configure("student.xml").addAnnotatedClass(Student.class);
		sf=config.buildSessionFactory();
		sess=sf.openSession();
		trans=sess.beginTransaction();
		
	}
	public void insert(Student s) {
		sess.persist(s);
		trans.commit();
		
	}
	public void fetchAll() {
		stuli=sess.createQuery("from Student").list();
		for(Student s:stuli) {
			System.out.println(s);
		}
	}
	public void fetchonId(int id) {
		Student s=sess.get(Student.class, id);
		System.out.println(s);
	}
	public void delete(int id) {
		Student s=sess.get(Student.class, id);
		if(s!=null)
		   sess.delete(s);
		else {
			System.out.println("No records found");
		}
	}

}
