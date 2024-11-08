package pkg;

public class progCompareTo { //Employee
	private int id;
	private String name;
	private String email;
	private String dept;
	private  int salary;
	
	progCompareTo(){
		
	}
	progCompareTo(int id,String name,String email,String dept,int salary){
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
     
     
	public static void main(String[] args) {
		progCompareTo p=new progCompareTo(18,"virat","virat@gmail.com","IT",1000000);
		System.out.println(p); // it gives hashcode because we need to override toString method

	}

}
