package ads.binarytree;

public class LeastCommonAncestor {

	public static void main(String[] args) {
		 Node<Integer> a = new Node<>(13);
	      Node<Integer> b = new Node<>(5);
	      Node<Integer> c = new Node<>(18);
	      Node<Integer> d = new Node<>(15);
	      Node<Integer> e = new Node<>(27);
	      Node<Integer> f = new Node<>(14);
	      Node<Integer> g = new Node<>(30);
	      Node<Integer> h = new Node<>(17);
	     // Node<Integer> x = new Node<>(3);

		
		a.setLeftChild(b);
		a.setRightChild(c);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
		//System.out.println(lca(a,e,f));
		lca(a,b,b);
		
	}
	
	public static Node<Integer> lca(Node<Integer> root,Node<Integer> a,
			Node<Integer> b){
		if(root == null) return null; //if we enouncter a null root, no ancestor was found
		
		if(root == a || root == b) return root; //if the current is either of the two nodes, then return root itself
		
		Node<Integer> leftLCA = lca(root.getLeftChild(),a,b);
		Node<Integer> rightLCA = lca(root.getRightChild(),a,b); //find the lca for the left and right subtrees
		
		if(leftLCA != null && rightLCA != null) //if both exist it means- either the node or its ancestor exists in the left and right subtree
			return root; 						// so the current node is the LCA
		
		if(leftLCA != null){
			System.out.println(leftLCA.getData());
			return leftLCA;//if only one of the common ancestors is non null return that
		}
		
		if(rightLCA != null)
			System.out.println(rightLCA.getData());
		return rightLCA;
	}

}
