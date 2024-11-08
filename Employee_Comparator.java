package pkg;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
public class Employee_Comparator {
	private int id;
	private String name;
	private String email;
	private String dept;
	private int salary;
	
	
	Employee_Comparator(){
		
	}
	Employee_Comparator(int id,String name,String email,String dept,int salary){
		this.id=id;
		this.name=name;
		this.email=email;
		this.dept=dept;
		this.salary=salary;
		
	}
     public void setId(int id) {
    	 this.id=id;
     }
     public int getId() {
    	 return id;
     }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		 return id+" "+name+" "+email+" "+dept+" "+salary+" ";
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Demo111 d1=new Demo111();
		Demo222 d2=new Demo222();
		Demo333 d3=new Demo333();
		Demo444 d4=new Demo444();
		Demo555 d5=new Demo555();
		TreeSet<Employee_Comparator> ts=new TreeSet<Employee_Comparator>(d1);
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			Employee_Comparator c =new Employee_Comparator();
			 System.out.println("Enter the details for "+(i+1)+" Employees");
			 String s1=sc.nextLine();
 
			String arr[]= s1.split(",");
			c.setId(Integer.parseInt(arr[0]));
			c.setName(arr[1]);
			c.setEmail(arr[2]);
			c.setDept(arr[3]);
			c.setSalary(Integer.parseInt(arr[4]));
			ts.add(c);
			
		}
		System.out.println(ts);
		

	}

}
class Demo111 implements Comparator<Employee_Comparator>{
	@Override
	public int compare(Employee_Comparator e1, Employee_Comparator e2) {
        Integer id1=e1.getId();
        Integer id2=e2.getId();
        
        return id1.compareTo(id2);
	}
	
	
}
class Demo222 implements Comparator<Employee_Comparator>{
	@Override
	public int compare(Employee_Comparator e1, Employee_Comparator e2) {
        
        return e1.getName().compareTo(e2.getName());
	}
}
class Demo333 implements Comparator<Employee_Comparator>{
	@Override
	public int compare(Employee_Comparator e1, Employee_Comparator e2) {
        
        return e1.getEmail().compareTo(e2.getEmail());
	}
}
class Demo444 implements Comparator<Employee_Comparator>{
	@Override
	public int compare(Employee_Comparator e1, Employee_Comparator e2) {
        
        return e1.getDept().compareTo(e2.getDept());
	}
}
class Demo555 implements Comparator<Employee_Comparator>{
	@Override
	public int compare(Employee_Comparator e1, Employee_Comparator e2) {
        Integer sal1=e1.getSalary();
        Integer sal2=e1.getSalary();
        return sal1.compareTo(sal2);
	}
	
	
}

