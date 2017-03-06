package ads.binarytree;

public class InsertionBST {

	public static void main(String[] args) {
		
	}
	
	public static Node<Integer> insert(Node<Integer> head, Node<Integer> node){
	if(head == null){ //check to see if node we are at exists in the tree
		return node; //base case, if the head null then the node itself is head
	}				
									//compare the node we are inserting with the node we are at
	
	if(node.getData() <= head.getData()){ //if the node value is smaller than the head  then its correct place 
										//is somewhere in the left subtree-we insert the node into the left subtree
		head.setLeftChild(insert(head.getLeftChild(), node));
	} else {
		head.setRightChild(insert(head.getRightChild(), node)); //if the node value is larger than the head  then its correct place 
															//is somewhere in the right subtree. we insert the node into the left subtree
	}
		
		
		return head; //return the parent of the node we just inserted into the tree
	}

}
