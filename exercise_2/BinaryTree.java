
public class BinaryTree{


	Node root;

	private Node addRecursive(Node current, int value ){
		if ( current == null )
			return new Node(value);

		if ( value < current.value ){
			current.left = addRecursive(current.left, value);
		} else if ( value > current.value ){
			current.right = addRecursive(current.right, value);
		}else{
			System.out.println("The element already exists");
		}
		
		return current;
	}

	private boolean searchRecursiveBinary(Node current, int value){
						
		if ( current == null)
			return false;

		if ( current.value == value )
			return true;

		if ( value < current.value) {
			return searchRecursiveBinary(current.left, value);
		}else if ( value > current.value ) {
			return searchRecursiveBinary(current.right, value);
		}

		return false;

	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	private Node removeRecursiveBinary( Node current , int value ){
		
		if (current == null) {
			return null;
		}
 
		if (value == current.value) {

			if (current.left == null && current.right == null) {
				return null;
			}

			if (current.right == null) {
				return current.left;
			}
 
			if (current.left == null) {
				return current.right;
			}

			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = removeRecursiveBinary(current.right, smallestValue);
			return current;

		} 
		
		if (value < current.value) {
			current.left = removeRecursiveBinary(current.left, value);
			return current;
		}

		current.right = removeRecursiveBinary(current.right, value);
		
		return current;

	}

	public void insert(int value){
		root = addRecursive(root,value);
	}

	public void lookup(int value){
		boolean IsFound = searchRecursiveBinary(root,value);
		
		if ( IsFound == true )
			System.out.println("Element with value = "+ String.valueOf(value) +" found");
		else
			System.out.println("Element with value = "+ String.valueOf(value) +" not found");

	}

	public void remove(int value){
		root = removeRecursiveBinary(root,value);
	}

}
