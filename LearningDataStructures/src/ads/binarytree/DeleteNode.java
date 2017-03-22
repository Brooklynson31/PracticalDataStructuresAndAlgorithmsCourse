package ads.binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class DeleteNode {

	public static void main(String[] args) {
		  Node<Integer> a = new Node<>(5);
	      Node<Integer> b = new Node<>(3);
	      Node<Integer> c = new Node<>(6);
	      Node<Integer> d = new Node<>(2);
	      Node<Integer> e = new Node<>(4);
	      Node<Integer> f = new Node<>(7);
//	      Node<Integer> g = new Node<>(30);
//	      Node<Integer> h = new Node<>(17);
//	      Node<Integer> x = new Node<>(3);
//	      Node<Integer> bb = new Node<>(10);


	
		a.setLeftChild(b);
		a.setRightChild(c);
		b.setLeftChild(e);
		b.setRightChild(d);
		c.setRightChild(f);
	
		
		
		System.out.println(delete(a,b));

	

	}
	
	//Main method in Delete node process
	public static Node<Integer> delete(Node<Integer> root, Node<Integer> targetNode){

		if(root == null) return null;
		
		Node<Integer> nodeToBeDeleted = lookUp(root,targetNode.getData()); //search for node to be deleted
		
		if(nodeToBeDeleted == null) return null; //node we want to delete does not exist in tree
		
		if(root == nodeToBeDeleted){ //node we are deleting is a root node
			root = deleteRootNode(root);

		} else {
		
			Node<Integer> deleteParent = findParent(root,nodeToBeDeleted); //find parent nsearch forode of node to be deleted and keep track of it
			
			
			
			//check how many children the node to be deleted has
			if(nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() != null){ //node to be dleted has 2 children
					//store the nodes that represent left and right subtrees of the node to be deleted
					Node<Integer> deleteNodeLeftChild =  nodeToBeDeleted.getLeftChild(); //root node in left subtree of node to be deleted
					Node<Integer> deleteNodeRightChild =  nodeToBeDeleted.getRightChild(); //root node in right subtree of node to be deleted
				
					//search for the biggest node in the left subtree of the node to be deleted
					Node<Integer> replaceNode = swapLargestValueLeftSub(nodeToBeDeleted.getLeftChild()); //store node we are swapping
				
					Node<Integer> replaceParent = findParent(root, replaceNode); //parent of node with highest value in left subtree
				
				
					if(replaceParent.getLeftChild() == replaceNode){
						replaceParent.setLeftChild(null);
				   }else {
					   replaceParent.setRightChild(null);
				   }
				
					//set the parent of the node that we are deleting to point to node with largest value in left subtree
					if(deleteParent.getLeftChild() == nodeToBeDeleted){ 
						deleteParent.setLeftChild(replaceNode);
					} else if (deleteParent.getRightChild() == nodeToBeDeleted){
						deleteParent.setRightChild(replaceNode); //replace node we are delete with node we are swapping it with
					}
					//check to see if node we are swapping has leaf nodes for children
						if(replaceParent == nodeToBeDeleted){
							replaceNode.setRightChild(deleteNodeRightChild); //largest value in left subtree will never have a right subtree so just set right subtree to child we are dleting
						} else {
							replaceNode.setLeftChild(deleteNodeLeftChild); //largest value in left subtree  is a leaf node so we replace left and right subtree to node we deleted
							replaceNode.setRightChild(deleteNodeRightChild);
						}
				
				} else if (nodeToBeDeleted.getLeftChild() != null || nodeToBeDeleted.getRightChild() != null){ //node to be deleted only has a left child
						if(nodeToBeDeleted.getLeftChild() != null)
							deleteParent.setLeftChild(nodeToBeDeleted.getLeftChild()); //set parent to point to child of deleted node
						else 
							deleteParent.setRightChild(nodeToBeDeleted.getRightChild()); //set parent to point to child of deleted node
				} else {
						removeNode(root,nodeToBeDeleted); //we are deleting a leaf node, so we can just set that value to null
				}
		}
		return root;
	}

	private static Node<Integer> deleteRootNode(Node<Integer> root) {
		//store the nodes that represent left and right subtrees of the node to be deleted
		Node<Integer> rootNodeLeftChild =  root.getLeftChild(); //root node in left subtree of node to be deleted
		Node<Integer> rootNodeRightChild =  root.getRightChild(); //root node in right subtree of node to be deleted

		//search for the biggest node in the left subtree of the node to be deleted
		Node<Integer> swapNode = swapLargestValueLeftSub(root.getLeftChild()); //store node we are swapping
		Node<Integer> parentSwap = findParent(root, swapNode); //parent of node with highest value in left subtree
		
		
		//delete node with largest value from left subtree od delete node
		if(parentSwap.getLeftChild() == swapNode){
			parentSwap.setLeftChild(null);
   }else {
		parentSwap.setRightChild(null);
   }
		
		//make swap node new root
		swapNode.setLeftChild(rootNodeLeftChild);
		swapNode.setRightChild(rootNodeRightChild);

		root = swapNode;
		return root;
	}
	
	
	public static Node<Integer> swapLargestValueLeftSub(Node<Integer> head){ //retrieves larget value in left subtree
		if(head.getRightChild() != null)
			head = swapLargestValueLeftSub(head.getRightChild());
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
