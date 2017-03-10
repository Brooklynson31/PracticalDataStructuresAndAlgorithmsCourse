package ads.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintPathsToLeafNode {

	public static void main(String[] args) {
		Node<Character> a = new Node<>('A');
		Node<Character> b = new Node<>('B');
		Node<Character> c = new Node<>('C');
		Node<Character> d = new Node<>('D');
		Node<Character> e = new Node<>('E');
		Node<Character> f = new Node<>('F');
		Node<Character> g = new Node<>('G');
		Node<Character> h = new Node<>('H');
		
		a.setLeftChild(b);
		a.setRightChild(c);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
		List<Character> test = new ArrayList<Character>();
		printPaths(a, test);
		
	}
	
	public static void printPaths(Node<Character> head, List<Character> test) {
		if(head == null) return;
		
		test.add(head.getData());

		if(head.getLeftChild() == null && head.getRightChild() == null)
			System.out.println(test);
		
			printPaths(head.getLeftChild(), test);
			printPaths(head.getRightChild(), test);
			
		test.remove(head);
	
	}

}
