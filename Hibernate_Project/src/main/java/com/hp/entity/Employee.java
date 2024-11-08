package com.hp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Column(name="empid")
	@Id
	private int empid;
	@Column(name="empname")
	private String empname;
	@Column(name="desig")
	private String desig;
	@Column(name="salary")
	private int salary;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee(int empid, String empname, String desig, int salary, String email, String password) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.desig = desig;
		this.salary = salary;
		this.email = email;
		this.password = password;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", desig=" + desig + ", salary=" + salary
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	

}
