package pkg;
import java.util.*;
class Cust3{
	private int id;
	private String name;
	private String email;
	private long phone;
	private String password;
	private String address;

	Cust3(int id,String name,String email,long phone,String password,String address){
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.password=password;
		this.address=address;
		
	}
	Cust3(){
		
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
public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Cust3 cus=new Cust3();
		int id=sc.nextInt();
		String name=sc.next();
		String email=sc.next();
		if(email.contains("gmail.com" )|| email.contains("yahoo.com")) {
			long phone=sc.nextLong();
			String pwd=sc.next();
			String addr=sc.next();
			Cust3 cus1=new Cust3 (id,name,email, phone,  pwd, addr);
			System.out.println(cus1.getId()+"\n"+cus1.getName()+"\n"+cus1.getEmail()+"\n"+cus1.getPhone()+"\n"+cus1.getPassword()+"\n"+cus1.getAddress());
				
		}
		else {
			System.out.println("MisMatch");
		}
		
		
		
		

	}

}
