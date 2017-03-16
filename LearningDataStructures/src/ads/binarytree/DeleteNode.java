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
	   //   Node<Integer> x = new Node<>(3);

	
		a.setLeftChild(b);
		a.setRightChild(c);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
		//System.out.println(delete(a,h));
		//breadthFirst(a);
		
		breadthFirst(delete(a,h));



	}
	
	//Main method in Delete node process
	public static Node<Integer> delete(Node<Integer> root, Node<Integer> targetNode){
		if(root == null) return null;
		
		Node<Integer> parent = root; //always keep track of the parent node
		
		//lookup node to be deleted
		Node<Integer> nodeToDeleteLeft = lookUp(parent.getLeftChild(),targetNode.getData()); //look in the left subtree for the node to be deleted
		Node<Integer> nodeToDeleteRight = lookUp(parent.getRightChild(),targetNode.getData()); //look in the right subtree for node to be deleted
		
		//store the value of the node to be deleted and its parent if they exists
		Node<Integer> nodeToBeDeleted = new Node<>(null);
		if(nodeToDeleteLeft != null) //node to be deleted was found in left subtree
			nodeToBeDeleted = nodeToDeleteLeft;
			//parent = findParent(root, nodeToBeDeleted);
		else if(nodeToDeleteRight != null) //node to be deleted was found in right subtree
			nodeToBeDeleted= nodeToDeleteRight;
		else if (root == targetNode){ //node to be deleted is the root
			nodeToBeDeleted = root;
		} else {
			return null; //node to be deleted does not exist in BST
		}
	
		//check how many children the node to be deleted has
		if(nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() != null){ //node to be dleted has 2 children
		//	Node<Integer> temp = nodeToBeDeleted;
			
			
			
		} else if (nodeToBeDeleted.getLeftChild() != null){ //node to be deleted only has a left child
//			Node<Integer> temp =  root.getLeftChild(); //hold the values of left and right subtrees of node to be swappped
//			
//			Node<Integer> swapNode = swapLeftSub(parent); //get the node with the biggest value in left subtree
//			parent.setLeftChild(swapNode); //swap node to be deleted 
//			
//			swapNode.setLeftChild(temp.getLeftChild()); //set left and right subtrees of newly swapped node to be same as
//			swapNode.setRightChild(temp.getRightChild()); //node that was swapped out
		
		} else if (nodeToBeDeleted.getRightChild()!= null ){ //node to be deleted only has a rigth child
			Node<Integer> temp =  nodeToBeDeleted; //hold the values of left and right subtrees of node to be swappped
			
			Node<Integer> swapNode = swapSmallValueRightSub(nodeToBeDeleted.getRightChild()); //get the node with the biggest value in left subtree
			parent.setRightChild(swapNode); //swap node to be deleted 
			
			swapNode.setLeftChild(temp.getLeftChild()); //set left and right subtrees of newly swapped node to be same as
			swapNode.setRightChild(temp.getRightChild()); //node that was swapped out
			
		} else { //node to be deleted is a leaf node
			
		}
		
		//remove
		removeNode(parent,nodeToBeDeleted);
	
		
		return parent;
	}
	
	
	public static Node<Integer> swapLargestValueLeftSub(Node<Integer> head){ //retrieves larget value in left subtree
	
		if(head.getRightChild() != null){
			swapLargestValueLeftSub(head.getRightChild());
		}
	
		return head;
	}
	
	public static Node<Integer> swapSmallValueRightSub(Node<Integer> head){ //retrieves  smallest value in right subtree
		if(head.getLeftChild() != null)
			swapSmallValueRightSub(head.getLeftChild()); //
		return head;
	}
	//returns parent of Node to be deleted
	public static Node<Integer> findParent(Node<Integer> head, Node<Integer> target){
		if(head.getLeftChild() == target || head.getRightChild() == target)
			return head;
		 
		
		if(target.getData() <= head.getData()) //if the lookup value is smaller than or equal to the head
			 removeNode(head.getLeftChild(),target); //lookup the left subtree
		else
			removeNode(head.getRightChild(), target); //otherwise lookup the right subtree
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
