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
	      
	      printRange(a, 0, 10);
	}
	
	public static void printRange(Node<Integer> head, int low, int high){
	if(head == null) return;	
	
	if(head.getData() <= high && head.getData() >= low)
		System.out.println(head.getData());
	
	if(head.getData() >= low)
		printRange(head.getLeftChild(), low, high);
	if(head.getData() <= high)
		printRange(head.getRightChild(),low,high);
		
		
		
		
	}

}
