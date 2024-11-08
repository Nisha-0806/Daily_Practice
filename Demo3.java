package pkg;

import java.util.*;
class Cust2 {
	private int id;
	private String name;
	private String email;
	private int phone;
	private String password;
	private String address;

	Cust2(int id,String name,String email,int phone,String password,String address){
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.password=password;
		this.address=address;
		
	}
	Cust2(){
		
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
	public int getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
}

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String arr[]=str.split(",");
		int id=Integer.parseInt(arr[0]);
		String nme=arr[1];
		String email=arr[2];
		int phn=Integer.parseInt(arr[3]);
		String pwd=arr[4];
		String addr=arr[5];
		Cust2 cu=new Cust2 (id,nme,email, phn,  pwd, addr);
		System.out.println(cu.getId()+"\n"+cu.getName()+"\n"+cu.getEmail()+"\n"+cu.getPhone()+"\n"+cu.getPassword()+"\n"+cu.getAddress());
		
		
		
		
	
		
		
		

	}

}
