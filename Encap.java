package pkg;
import java.util.*;
 class Encap {
	private int id;
	private String name;
	private String addr;
	private int sal;
	
	 Encap(){
		 
		 
	 }
    public Encap(int id, String name, String addr, int sal) {
	
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
		Encap e1=new Encap();
		
		//Encap e2=new Encap();
		/*e2.setId(1);
		e2.setNme("nisha");
		e2.setAddr("TN");
		e2.setSal(80_000);*/
		
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		String nme=sc.next();
		String add=sc.next();
		int sal=sc.nextInt();
		e1.setId(id);
		e1.setNme(nme);
		e1.setAddr(add);
		e1.setSal(sal);
		
		System.out.println(e1.getId()+" "+ e1.getNme()+" "+e1.getAddr()+" "+e1.getSal());
		
		// using constructors
		Encap e2=new Encap(2,nis,delhi,90000);
		
		
	}
	
		
		

	

}
