package ads.binarytree;

import ads.binarytree.BinaryTreeBreadthFirstTraversal.Node;
import ads.binarytree.Queue.QueueOverflowException;
import ads.binarytree.Queue.QueueUnderflowException;

public class MirrorABinaryTree {

	public static void main(String[] args) throws QueueUnderflowException, QueueOverflowException {
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
        BinaryTreeBreadthFirstTraversal test = new BinaryTreeBreadthFirstTraversal();


        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        b.setLeftChild(x);
        g.setLeftChild(t);
       
        test.breadthFirst(a);
        mirrorBST(a);
        test.breadthFirst(a);
	}
	//Personal Solution
	public static Node<Character> mirrorBST(Node<Character> head){
		if(head == null) return null;
		
		Node<Character> left = head.getLeftChild();
		Node<Character> right = head.getRightChild();
		
		head.setLeftChild(mirrorBST(right));
		head.setRightChild(mirrorBST(left));

		return head;
	}
	
	public static void mirror(Node<Character> root){
		if(root == null) return;
		
		mirror(root.getLeftChild());
		mirror(root.getRightChild());
		
		Node<Character> temp = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(temp);
		
	}

}
