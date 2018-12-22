public class Main
{

	public static void main(  String[] args ){



		long start = System.nanoTime();
		
		Node node = new Node(0);	
		node.insert_node();
		node.insert_node();

		node.print();
		
		long elapsed = System.nanoTime() - start;

		System.out.println(elapsed);





	}	

}
