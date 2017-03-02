package ads.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import ads.binarytree.BinaryTreeBreadthFirstTraversal.Node;

public class DeleteBST {

	public static void main(String[] args) {
		Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
//        Node<Character> d = new Node<>('D');
//        Node<Character> e = new Node<>('E');
//        Node<Character> f = new Node<>('F');
//        Node<Character> g = new Node<>('G');
//        Node<Character> h = new Node<>('H');
//        Node<Character> x = new Node<>('X');
//        Node<Character> t = new Node<>('T');


        a.setLeftChild(b);
        a.setRightChild(c);
//        c.setLeftChild(d);
//        c.setRightChild(e);
//        d.setLeftChild(f);
//        d.setRightChild(h);
//        e.setRightChild(g);
//        b.setLeftChild(x);
        
        delete(a,'B');
        breadthFirst2(a);

	}
	
	public static Node<Character> delete(Node<Character> head,char c){
		
		if(head == null) return null;
		
		if(head.getData() == c)
			return null;
		
		if(c < head.getData())
			  head.setLeftChild(delete(head.getLeftChild(),c));
		else
			head.setRightChild(delete(head.getRightChild(),c));
		
		
		return head;
	}
	
	public static void breadthFirst2(Node<Character> root){
		if(root == null) //null root indicates nothing to traverse
			return;
		
		
		
		Queue<Node<Character>> queue = new LinkedList<Node<Character>>();
		queue.add(root);  //set up a queue and start by enqueueing the root node
		
		while(!queue.isEmpty()){ //As long as the queue is not empty, process the Node at the head of the queue
			Node<Character> node = queue.remove();
			System.out.println(node.getData());
			
			if(node.getLeftChild() != null){ // adding the left child first ensures that the nodes at the Same Level are processed from left to right
				queue.add(node.getLeftChild()); // adds left child to queue
			}
			if(node.getRightChild() != null){ //make sure it is not null
				queue.add(node.getRightChild());//adds right child to queue
			}
		}
		
	}

}
