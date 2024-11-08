package pkg;
import java.util.*;
class Cust1 {
	private int id;
	private String name;
	private String email;
	private long phone;
	private String password;
	private String address;

	
	void setName(String name) {
		this.name=name;
	}
	void setEmail(String email ) {
		this.email=email;
	}
	void setPhone(long phone ) {
		this.phone=phone;
	}
	void setPwd(String password ) {
		this.password=password;
	}
	 void setAddress(String address) {
		this.address = address;
	}

	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	
	
	
}

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Cust1 c=new Cust1();
		for(int i=1;i<=n;i++) {
			
			String name=sc.next();
			String email=sc.next();
			Long phone=sc.nextLong();
			String pwd=sc.next();
			String addr=sc.next();
			
			c.setName(name);
			c.setEmail(email);
			c.setPhone(phone);
			c.setPwd(pwd);
			c.setAddress(addr);
			
			
		}
		for(int i=1;i<=n;i++) {
			System.out.println(i);
			System.out.println(c.getName()+"\n"+c.getEmail()+"\n"+c.getPhone()+"\n"+c.getPassword()+"\n"+c.getAddress());
			
		}
	}

}
