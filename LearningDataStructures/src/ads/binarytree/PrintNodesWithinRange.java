package ads.binarytree;

public class PrintNodesWithinRange {

	public static void main(String[] args) {

		  Node<Integer> a = new Node<>(13);
	      Node<Integer> b = new Node<>(5);
	      Node<Integer> c = new Node<>(18);
	      Node<Integer> d = new Node<>(15);
	      Node<Integer> e = new Node<>(27);
	      Node<Integer> f = new Node<>(14);
	      Node<Integer> g = new Node<>(30);
	      Node<Integer> h = new Node<>(17);
	      Node<Integer> x = new Node<>(3);

	      

	      a.setLeftChild(b);
	      a.setRightChild(c);
	      c.setLeftChild(d);
	      c.setRightChild(e);
	      d.setLeftChild(f);
	      d.setRightChild(h);
	      e.setRightChild(g);
	      b.setLeftChild(x);
	      
	      printRange(a, 10, 20);

	      printRange2(a, 10, 20);
	}
	
	//prints nodes according to how they appear in breadth first search
	public static void printRange(Node<Integer> head, int low, int high){
	if(head == null) return;	
	
	if(head.getData() <= high && head.getData() >= low)
		System.out.println(head.getData());
	
	if(head.getData() >= low)
		printRange(head.getLeftChild(), low, high);
	if(head.getData() <= high)
		printRange(head.getRightChild(),low,high);
	}
	
	//--> prints node values in numerical order
	public static void printRange2(Node<Integer> root, int low, int high){ //pass in the min and max indicating the range we care about
		
	if(root == null) return; //bse case, nothing to do for a null root
	
	if(low <= root.getData())
		printRange2(root.getLeftChild(),low,high); //if the range low value is less than the current node, run the operation on the left subtree
	
	if(low <= root.getData() && root.getData() <= high) //check the node value to see if its within the range, if yes, print
		System.out.println(root.getData());
	
	if(high > root.getData())
		printRange2(root.getRightChild(), low, high); //if the range high value is greater than the current node, run the oepration on the right subtree
		
		
	}

}
