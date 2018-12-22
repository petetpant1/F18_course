

public class Node{


	long number_of_node;
	Node next;

	Node(long number_of_node){
		this.number_of_node = number_of_node;
	}


	public void insert_node(){

		if ( this.next == null ){
			this.next = new Node(this.number_of_node+1);
		}else{
			next.insert_node();
		}

		return;
	}

	public void delete_node(){

		System.out.println("dummy delete");

	}


	public void print(){
		System.out.println("node number: "+ Long.toString(number_of_node) );
	
		if ( next != null ) {
			next.print();	
		}

	}



}
