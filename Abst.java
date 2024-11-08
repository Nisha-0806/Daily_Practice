package pkg;


	abstract class Bird{
		abstract void eat();
		abstract void fly();
	}
	abstract class Eagle extends Bird{
        @Override
        void fly() {
        	System.out.println("Eagle flies at higher heights");
        	
        }
		
	}
	class serpentEagle extends Eagle{
		@Override
		void eat() {
			System.out.println("serpentEagle eats snakes");
			
		}
	}
	class goldenEagle extends Eagle{
		@Override
		void eat() {
			System.out.println("Golden Eagle eats fishes");
			
		}
	}
	class BirdFamily{
		public void disp(Eagle e) {
			e.eat();
			e.fly();
		}
		
	}
	public class Abst{
          public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		serpentEagle se=new serpentEagle();
		goldenEagle ge=new goldenEagle();
		BirdFamily bf=new BirdFamily();
		se.fly();
		se.eat();
		ge.fly();
		ge.eat();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Ussing polymorphism");
		
		bf.disp(se);
		bf.disp(ge);
		
		

	}

}
