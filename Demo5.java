package pkg;

import java.util.Scanner;

class Cust4{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String address;

	Cust4(int id,String name,String email,String phone,String password,String address){
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.password=password;
		this.address=address;
		
	}
	Cust4(){
		
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone(){
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
}
public class Demo5 {
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		String name=sc.next();
		String email=sc.next();
		String str=sc.next();
		if(str.startsWith("6") || str.startsWith("7") || str.startsWith("8") || str.startsWith("9")) {
			String pwd=sc.next();
			String addr=sc.next();
			Cust4 cus1=new Cust4 (id,name,email, str,pwd,addr);
			System.out.println(cus1.getId()+"\n"+cus1.getName()+"\n"+cus1.getEmail()+"\n"+cus1.getPhone()+"\n"+cus1.getPassword()+"\n"+cus1.getAddress());
				
		}
		else {
			System.out.println("MisMatch");
		}

	}
}


