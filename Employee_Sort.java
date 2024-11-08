package pkg;

import java.util.Scanner;
import java.util.TreeSet;

public class Employee_Sort implements Comparable<Employee_Sort> {
	private int id;
	private String name;
	private String email;
	private String dept;
	private  int salary;
	
    Employee_Sort(){
		
	}
	Employee_Sort(int id,String name,String email,String dept,int salary){
		this.id=id;
		this.name=name;
		this.email=email;
		this.dept=dept;
		this.salary=salary;
		
	}
	public int getId() {
		return id;
	}
	void setId(int id) {
		this.id=id;
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
    @Override
    public int compareTo(Employee_Sort e2) {
    	//sort based on id
//    	Employee_Sort e1= this;
//    	Integer id1=e1.id;
//    	Integer id2=e2.id;
//    	return id1.compareTo(id2);
    	    	  
    	//sort based on names
    	
    	Employee_Sort e1=this;
    	String name1=e1.name;
    	String name2=e2.name;
    	if(name1==name2) {
    		return e1.email.compareTo(e2.email);
    	}
    	return name1.compareTo(name2);
    	
    	
    }
     
	public static void main(String[] args) {
		/*Employee_Sort e1=new Employee_Sort(2,"virat", "virat@gmail.com", "IT", 1000000 );
		Employee_Sort e2=new Employee_Sort(1,"anushka", "anushka@gmail.com", "IT", 100000 );
		Employee_Sort e3=new Employee_Sort(3,"adi", "adi@gmail.com", "sales", 200000 );
		ArrayList al=new ArrayList();
		al.add(e1);
		al.add(e2);
		al.add(e3);
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);*/
		
		
		//by user input
		Scanner sc=new Scanner(System.in);
		//ArrayList<Employee_Sort>al=new ArrayList<>();
		TreeSet<Employee_Sort>ts=new TreeSet<>();
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			 Employee_Sort e=new Employee_Sort();
			 System.out.println("Enter the details for "+(i+1)+" Employees");
			 String s1=sc.nextLine();
 
			String arr[]= s1.split(",");
			e.setId(Integer.parseInt(arr[0]));
			e.setName(arr[1]);
			e.setEmail(arr[2]);
			e.setDept(arr[3]);
			e.setSalary(Integer.parseInt(arr[4]));
			ts.add(e);
			
		}
		System.out.println(ts);
		

	}

}
