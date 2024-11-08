package com.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name="student")

public class Student {
	@Id()
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="stu_id")
	private static int stu_id;
	@Column(name="stu_name")
	private String stu_name;
	@Column(name="stu_email")
	private String stu_email;
	@Column(name="stu_mobile")
	private String stu_mobile;
	
	
	public Student(int stu_id,String stu_name, String stu_email, String stu_mobile) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_email = stu_email;
		this.stu_mobile = stu_mobile;
	}
	public Student(String stu_name, String stu_email, String stu_mobile) {
		super();
		this.stu_name = stu_name;
		this.stu_email = stu_email;
		this.stu_mobile = stu_mobile;
	}
	public Student() {
		super();
	}
	public static int getStu_id() {
		return stu_id;
	}
	public static void setStu_id(int stu_id) {
		Student.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getStu_mobile() {
		return stu_mobile;
	}
	public void setStu_mobile(String stu_mobile) {
		this.stu_mobile = stu_mobile;
	}
	@Override
	public String toString() {
		return "Student [stu_name=" + stu_name + ", stu_email=" + stu_email + ", stu_mobile=" + stu_mobile + "]";
	}
	
	
}
