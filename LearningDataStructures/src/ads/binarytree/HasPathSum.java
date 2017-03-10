package ads.binarytree;

public class HasPathSum {

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
	      
	      System.out.println(hasPathSum(a, 62));
	      System.out.println(hasPathSum2(a, 62));


	}
	
	//Personal Solution
	public static boolean hasPathSum(Node<Integer> head, int sum){
		if(head == null) 
			return false;
		
		if(head.getLeftChild() == null && head.getRightChild() == null)
			return (0 == sum-head.getData());
		else
			return hasPathSum(head.getLeftChild(),sum-head.getData()) || hasPathSum(head.getRightChild(), sum-head.getData());
	}
	
	
	//Instructor Solution
	public static boolean hasPathSum2(Node<Integer> head, int sum){
		if(head.getLeftChild() == null && head.getRightChild() == null) //pass in the current running sum
			return sum == head.getData(); //in the case of a leaf node, check if the sum is exactly equal to the value of the node
		
		int subSum = sum -head.getData();  // for internal nonleaf nodes, subtract the current node value from the sum
		
		if(head.getLeftChild() != null){ //recurse left to see if the sub sum is satisfied in any of the paths in left subtree
			boolean hasPathSum = hasPathSum2(head.getLeftChild(), subSum);
			if(hasPathSum)
			return true;
		}
		
		if(head.getRightChild() != null){
			boolean hasPathSum = hasPathSum2(head.getRightChild(),subSum); //recurse right to see if the sub sum is satisfied is any  paths in right subtree 
			if(hasPathSum)
			return true;
		}
		
		return false; //return false if the sum has not been found along any of the sub trees
	}

}
