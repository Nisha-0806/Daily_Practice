package pkg;

class Queue{
	private int data;
	public boolean dataPresent=false;
	
	public synchronized void setData(int data) {
			if(dataPresent==false) {
				this.data=data;
			  System.out.println("producer produced the data "+data);
			  dataPresent=true;
			  notify();
			  
		}
		else {
			try {
				wait();
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	 }
  }
	public synchronized void getData() {
		
			if(dataPresent==true) {
			  System.out.println("consumer consuming the data "+data);
			  dataPresent=false;
			  notify();
			}
			else {
				try{
					  wait();
				  }
				  catch(Exception e) {
					  e.printStackTrace();
				  }
			  
		}
	}
	
		
}
class Producer extends Thread{
	@Override
	public void run() {
		int i=1;
		for(;;) {
			q.setData(i++);
		}
	
	}
	Queue q;
	Producer(Queue q){
		this.q=q;
	}
	
}

class Consumer extends Thread{
	Queue q;
	Consumer(Queue q){
		this.q=q;
	}
	@Override
	public void run() {
		for(;;) {
			q.getData();
		}
		
	}
	
}


public class ProducerConsumer {

	public static void main(String[] args) {
		Queue q=new Queue();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		p.setName("Producer");
		c.setName("Consumer");
		p.start();
		c.start();
		

	}

}
