package ads.binarytree;

public class isBinarySearchTree {

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
	      
	      System.out.println(isBST(a, 0, 40));
	}
	
	public static boolean isBST(Node<Integer> root, int min, int max){ //pass in the min and max indicating the range for the subtree
		if(root == null) return true; //a null node is a valid binary tree
		
		if(root.getData() <= min || root.getData() > max)//if any node lies outside the range then the BST constraint has been violated and we return false
			return false;
		
		return isBST(root.getLeftChild(), min, root.getData()) && isBST(root.getRightChild(), root.getData(), min); //check the left and right subtrees to see if theyre valid search trees
		//Note how the range for the checks change
		//For the Left Subtree the current nodes value should be the max
		//For the right subtree the current nodes value should be the min
	}

}
