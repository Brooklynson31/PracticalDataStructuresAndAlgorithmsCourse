package ads.binarytree;

public class MinValue {

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
	      
      
      System.out.println(minValue(a));
	}

	
	
	public static int minValue(Node<Integer> root){
		if(root == null) return -1;
		
		if(root.getLeftChild() == null)
			return(root.getData());
		else
			return minValue(root.getLeftChild());
		
		
	}
	
	public static int minValue2(Node<Integer> root){
		if(root == null)	//base case, if the head is null, then the tree has no nodes, 
			return Integer.MIN_VALUE; //return the minimum integer value
		
		if(root.getLeftChild() == null) // follow the left child for every node,
			return(root.getData()); // if the left child is null then this is the minimum value node
		
		
		return minValue2(root.getLeftChild()); //recurse till a left child is available
		
		
	}
}
