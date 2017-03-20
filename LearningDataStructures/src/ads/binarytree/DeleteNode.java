package ads.binarytree;

import java.util.LinkedList;
import java.util.Queue;


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
		b.setLeftChild(x);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
		
		breadthFirst(delete(a,d));

	

	}
	
	//Main method in Delete node process
	public static Node<Integer> delete(Node<Integer> root, Node<Integer> targetNode){

		if(root == null) return null;
		
		Node<Integer> nodeToBeDeleted = lookUp(root,targetNode.getData()); //search for node to be deleted
		
		if(nodeToBeDeleted == null) return null; //node we want to delete does not exist in tree
		
		Node<Integer> parent = findParent(root,nodeToBeDeleted); //find parent nsearch forode of node to be deleted and keep track of it
		
	
		//check how many children the node to be deleted has
		if(nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() != null){ //node to be dleted has 2 children
			//store the nodes that represent left and right subtrees of the node to be deleted
			Node<Integer> deleteNodeLeftChild =  nodeToBeDeleted.getLeftChild(); //root node in left subtree of node to be deleted
			Node<Integer> deleteNodeRightChild =  nodeToBeDeleted.getRightChild(); //root node in right subtree of node to be deleted
			
			//search for the biggest node in the left subtree of the node to be deleted
			Node<Integer> swapNode = swapLargestValueLeftSub(nodeToBeDeleted.getLeftChild()); //store node we are swapping
	
			//find the parent of the node we are swapping with the node we are deleting
			Node<Integer> parentSwap = findParent(root, swapNode); //parent of node with highest value in left subtree
			
			if(parentSwap == nodeToBeDeleted){
				//check to see if node we are deleting has two leaf nodes or not
			} else {
				
			}
			
			//set the parent of the node that we are deleting to point to swap node replacing the node we are deleting in tree
			if(parent.getLeftChild() == nodeToBeDeleted){ 
				parent.setLeftChild(swapNode);
			} else if (parent.getRightChild() == nodeToBeDeleted){
				parent.setRightChild(swapNode); //replace node we are delete with node we are swapping it with
			}
			
			//replace the larget value in left subtree with node we are deleted
			if(parentSwap.getLeftChild() == swapNode){
				parentSwap.setLeftChild(null);
			} else {
				parentSwap.setRightChild(null);
			}
			
		
			swapNode.setLeftChild(deleteNodeLeftChild);
			swapNode.setRightChild(deleteNodeRightChild);

	
			
		} else if (nodeToBeDeleted.getLeftChild() != null || nodeToBeDeleted.getRightChild() != null){ //node to be deleted only has a left child
			if(nodeToBeDeleted.getLeftChild() != null)
				parent.setLeftChild(nodeToBeDeleted.getLeftChild());
			 else 
				parent.setRightChild(nodeToBeDeleted.getRightChild());
		} else {
			removeNode(root,nodeToBeDeleted);
		}

		return root;
	}
	
	
	public static Node<Integer> swapLargestValueLeftSub(Node<Integer> head){ //retrieves larget value in left subtree
		if(head.getRightChild() != null)
			head = swapLargestValueLeftSub(head.getRightChild());
		return head;
	}
	
	public static Node<Integer> swapSmallValueRightSub(Node<Integer> head){ //retrieves  smallest value in right subtree
		if(head.getLeftChild() != null)
			head = swapSmallValueRightSub(head.getLeftChild()); //
		return head;
	}
	
	
	//returns parent of 2nd paramter
	public static Node<Integer> findParent(Node<Integer> head, Node<Integer> target){//2nd parameter is who's parent we are looking for
		if(head.getLeftChild() == target || head.getRightChild() == target)
			return head;
		 
		
		if(target.getData() <= head.getData()) //if the lookup value is smaller than or equal to the head
			head = findParent(head.getLeftChild(),target); //lookup the left subtree
		else
			 head = findParent(head.getRightChild(), target); //otherwise lookup the right subtree
		return head;
		
		
	}
	
	public static void removeNode(Node<Integer> head,Node<Integer> target){ // deletes the node we are searching for 
		if(head.getLeftChild() == target){
			head.setLeftChild(null);
			return;
		} else if (head.getRightChild() == target){
			head.setRightChild(null);
			return;
		}
				
		
		if(target.getData() <= head.getData()) //if the lookup value is smaller than or equal to the head
			 removeNode(head.getLeftChild(),target); //lookup the left subtree
		else
			 removeNode(head.getRightChild(), target); //otherwise lookup the right subtree
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
