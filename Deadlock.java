package pkg;

class Warriors extends Thread{
	String res1="Brahmastra";
	String res2="pashupatastra";
	String res3="sarpastra";
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("ARJUNA")) {
			arjuna();
		}
		else {
			karna();
		}
	}
	
	synchronized void arjuna(){
		try {
			Thread.sleep(3000);
			synchronized (res1) {
				System.out.println("arjuna acquired resource1");
				Thread.sleep(2000);
			
				
				synchronized(res2) {
					System.out.println("Arjuna acquired resource2");
					Thread.sleep(2000);
				
				synchronized(res3) {
					System.out.println("Arjuna acquired resource3");
					Thread.sleep(2000);
				}
			}
		}

	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	void karna(){
		try {
			Thread.sleep(3000);
			synchronized (res3) {
				System.out.println("Karna acquired resource3");
				Thread.sleep(2000);
			
			
				synchronized(res2) {
					System.out.println("Karna acquired resource2");
					Thread.sleep(2000);
				
				synchronized(res1) {
					System.out.println("Karna acquired resource1");
					Thread.sleep(2000);
				}
			  }
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

public class Deadlock {

	public static void main(String[] args) {
		Warriors w1=new Warriors();
		w1.setName("ARJUNA");
		Warriors w2=new Warriors();
		w2.setName("KARNA");
		w1.start();
		w2.start();

		

	}

}
