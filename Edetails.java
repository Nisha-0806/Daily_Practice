package pkg;
import java.util.*;
class Edetails{
	private int id;
	private String name;
	private String addr;
	private int sal;
	
	 Edetails(){
		 
		 
	 }
    public Edetails(int id, String name, String addr, int sal) {
	
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.sal = sal;
	}
	void setId(int id){
		 this.id=id;
	 }
	
	 void setNme(String name){
		 this.name=name;
	 }
     void setAddr(String addr){
		 this.addr=addr;
	 }
     void setSal(int sal) {
    	 this.sal=sal;
    	 
     }
      
    public int getId() {
    	 return id;
     }
    public String getNme() {
   	 return name;
    }
    public String getAddr() {
   	 return addr;
    }
    public int getSal() {
   	 return sal;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("n of objects");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			Edetails e1=new Edetails();
			System.out.println("Enter the data");
			String data=sc.next();
			String arr[]=data.split(",");
			
			int id1=Integer.parseInt(arr[0]);
			String name1=arr[1];
			String addr1=arr[2];
			int sal1=Integer.parseInt(arr[3]);
			
			
			e1.setId(id1);
			e1.setNme(name1);
			e1.setAddr(addr1);
			e1.setSal(sal1);
			
			System.out.println(e1.getId()+" "+ e1.getNme()+" "+e1.getAddr()+" "+e1.getSal());
			Edetails e4=new Edetails();
			Edetails e5=new Edetails();
			Edetails e6=new Edetails();
			
			Edetails arr1[]=new Edetails[3];
			arr1[0]=e4;
			arr1[1]=e5;
			arr1[2]=e6;
			
			System.out.println(arr[0].get);
			
			
			
			
		}
		
	}
	
		
		

	

}
