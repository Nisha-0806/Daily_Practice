package pkg;
import java.util.*;
class Customer{
		private int id;
		private String name;
		private String email;
		private long phone;
		private String password;
		private String address;
		
		
		void setId(int id){
			this.id=id;
		}
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
class Demo1{
	  public static void main(String[] args) {
			// TODO Auto-generated method stub
				Customer cus=new Customer();
				Scanner sc=new Scanner(System.in);
				int id=sc.nextInt();
				String name=sc.next();
				String email=sc.next();
				Long phone=sc.nextLong();
				String pwd=sc.next();
				String addr=sc.nextLine();
				cus.setId(id);
				cus.setName(name);
				cus.setEmail(email);
				cus.setPhone(phone);
				cus.setPwd(pwd);
				cus.setAddress(addr);
				
				System.out.println(cus.getId()+" "+cus.getName()+" "+cus.getEmail()+" "+cus.getPhone()+" "+cus.getPassword()+" "+cus.getAddress());
				
				
				
	  }
	
}
		

      
			



