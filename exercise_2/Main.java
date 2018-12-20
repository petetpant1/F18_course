import java.util.Random;


public class Main{

       static BinaryTree bt;


	static class RunnableTest implements Runnable{

		public void run(){

			Random rand = new Random();

			int number,operation,i; 
	
			for ( i = 0 ; i < 100; i++){
				number = rand.nextInt(20) + 1;		

				operation = rand.nextInt(3)+ 1;
				switch(operation){

					case 1: bt.insert(number);
					case 2: bt.remove(number);
					case 3: bt.lookup(number); 		

				}
			

			}


		}


	}

        public static void main(String[] args){

                bt = new BinaryTree();


                Runnable r1 = new RunnableTest();
                Thread t = new Thread(r1);
                Runnable r2 = new RunnableTest();
                Thread t2 = new Thread(r2);

                t.start();
                t2.start();

                System.out.println("Just before return");
        }


}
