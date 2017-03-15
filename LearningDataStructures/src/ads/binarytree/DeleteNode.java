package ads.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import ads.binarytree.BinaryTreeBreadthFirstTraversal.Node;

public class DeleteNode {

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
		
		breadthFirst(a);


	}
	
	public static Node<Integer> delete(Node<Integer> root, Node<Integer> target){
		if(root == null) return null;
		
		if(root == target) return root;
		
		Node<Integer> found = new Node<Integer>(null);
		
	
		if(root.getData() <= target.getData())
			found = delete(root.getLeftChild(),target);
		else if(root.getData() > target.getData())
			found = delete(root.getRightChild(),target);
		
			
		if((found.getLeftChild() == null && found.getRightChild() == null) || found.getLeftChild() == null ) {
			root.setLeftChild(leftSub(found));
		}
			
		if(found.getRightChild() == null){
			root.setRightChild(rightSub(found));
		}
		
		return null;
	}
	
	public static Node<Integer> leftSub(Node<Integer> head){ //search for biggest value in left subtree
		if(head == null) return null;
		
		if(head.getRightChild() != null){
			  leftSub(head.getRightChild());
		}
	
		return head;
	}
	
	public static Node<Integer> rightSub(Node<Integer> head){ //search for biggest value in left subtree
		if(head == null) return null;
		
		if(head.getLeftChild() != null){
			  rightSub(head.getLeftChild());
		}
	
		return head;
	}
	
	public static void swap(Node<Integer> head){
		
	}
	
	public static Node<Integer> lookUp(Node<Integer> head, int data){
		if(head == null)
			return null; //base case, if the head null the node has not been found; return null
		
		if(head.getData() == data) //check if the value of the head matches the value were looking up, 
			return head;			//if yes then we've found a match
			
		
		if(data <= head.getData()) //if the lookup value is smaller than or equal to the head
			return lookUp(head.getLeftChild(),data); //lookup the left subtree
		else
			 return lookUp(head.getRightChild(), data); //otherwise lookup the right subtree
	
	}
	
	
	
	public static void breadthFirst(Node<Integer> root) {
		if(root == null) //null root indicates nothing to traverse
			return;
		
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.add(root);  //set up a queue and start by enqueueing the root node
		
		while(!queue.isEmpty()){ //As long as the queue is not empty, process the Node at the head of the queue
			Node<Integer> node = queue.remove();
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
