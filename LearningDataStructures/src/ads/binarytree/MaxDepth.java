package ads.binarytree;

import ads.binarytree.BinaryTreeBreadthFirstTraversal.Node;

public class MaxDepth {

	public static void main(String[] args) {
		Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        Node<Character> x = new Node<>('X');
        Node<Character> t = new Node<>('T');


        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        b.setLeftChild(x);
        g.setLeftChild(t);
        
        System.out.println(maxDepth(a));
	}
	
	public static int maxDepth(Node<Character> root){
		if (root == null) return 0; //stop condition - when you arrive at a leaf node start counting up
		else {
			int lDepth = maxDepth(root.getLeftChild()); //check the depth of left and right subtree for every node
			int rDepth = maxDepth(root.getRightChild()); 
			
			if(lDepth > rDepth)
				return lDepth+1; //only return to each node the length of the longer sub tree
			else				// increment on each side for every node you come across
				return rDepth+1;
			}
		
	}
	
	public static int maxDepth2(Node<Character> root){
		if(root == null) return 0; //base case, if the root is null then the tree has no nodes, the max depth is 0
		
		if(root.getData() == null && root.getRightChild() == null){ //if both the left and right child of the node is null
			return 0;										//then this is a leaf and has a depth of 0
		}
		
		int leftMaxDepth = 1 + maxDepth2(root.getLeftChild()); //Find the max depth on the left and right subtrees
		int rightMaxDepth = 1 + maxDepth2(root.getRightChild()); //add 1 to account for the current tree depth of the tree
		
		return Math.max(leftMaxDepth, rightMaxDepth); //find the max depth between the left and right subtrees
	}

}
