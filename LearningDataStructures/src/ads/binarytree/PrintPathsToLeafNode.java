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
		List<Character> test2 = new ArrayList<Character>();

		printPaths(a, test);
		printPaths2(a,test2);
		
	}
	//Personal Solution
	public static void printPaths(Node<Character> head, List<Character> test) {
		if(head == null) return;
		
			if(head.getLeftChild() == null && head.getRightChild() == null)
			System.out.println(test);
		
			test.add(head.getData());
			printPaths(head.getLeftChild(), test);
			printPaths(head.getRightChild(), test);
			
			
			
		test.remove(head.getData());
	}
	//Instructor Solution
	public static void printPaths2(Node<Character> root, List<Character> pathList){//a list keeping track of the curren tpath to this node
		if(root == null) return; //a null root nothing to do
		
		pathList.add(root.getData()); //add the current node to the path and recurse to the left and right child
		printPaths2(root.getLeftChild(), pathList);
		printPaths2(root.getRightChild(), pathList);
		
		if(root.getLeftChild() == null && root.getRightChild() == null)
			System.out.println(pathList); //if this is a lead node, print the curren tpath, which has all the nodes leading to this leaf node
		
		pathList.remove(root.getData());
			
	}

}
