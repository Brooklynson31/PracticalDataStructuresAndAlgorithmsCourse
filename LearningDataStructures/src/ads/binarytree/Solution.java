package ads.binarytree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    
    	public static TreeNode delete(TreeNode root, int target){

		if(root == null) return null;
		
		TreeNode targetNode = new TreeNode(target);
		
		TreeNode nodeToBeDeleted = lookUp(root,targetNode.getData()); //search for node to be deleted
		
		if(nodeToBeDeleted == null) return null; //node we want to delete does not exist in tree
		
		if(root == nodeToBeDeleted){ //node we are deleting is a root node
			root = deleteRootNode(root);

		} else {
		
			TreeNode deleteParent = findParent(root,nodeToBeDeleted); //find parent nsearch forode of node to be deleted and keep track of it
			
			
			
			//check how many children the node to be deleted has
			if(nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() != null){ //node to be dleted has 2 children
					//store the nodes that represent left and right subtrees of the node to be deleted
					TreeNode deleteNodeLeftChild =  nodeToBeDeleted.getLeftChild(); //root node in left subtree of node to be deleted
					TreeNode deleteNodeRightChild =  nodeToBeDeleted.getRightChild(); //root node in right subtree of node to be deleted
				
					//search for the biggest node in the left subtree of the node to be deleted
					TreeNode replaceNode = swapLargestValueLeftSub(nodeToBeDeleted.getLeftChild()); //store node we are swapping
				
					TreeNode replaceParent = findParent(root, replaceNode); //parent of node with highest value in left subtree
				
				
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
					//check to see if node we are using as replacement has leaf nodes for children
						
						if(replaceParent == nodeToBeDeleted){ //the replacement node is has leaf nodes
							replaceNode.setRightChild(deleteNodeRightChild); //largest value in left subtree will never have a right subtree so just set right subtree to child we are dleting
						} else { //replace node does not have children
							replaceNode.setLeftChild(deleteNodeLeftChild); 
							replaceNode.setRightChild(deleteNodeRightChild);//largest value in left subtree  is a leaf node so we replace left and right subtree to node we deleted
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

	private  TreeNode deleteRootNode(TreeNode root) {
		//store the nodes that represent left and right subtrees of the node to be deleted
		TreeNode rootNodeLeftChild =  root.getLeftChild(); //root node in left subtree of node to be deleted
		TreeNode rootNodeRightChild =  root.getRightChild(); //root node in right subtree of node to be deleted

		//search for the biggest node in the left subtree of the node to be deleted
		TreeNode swapNode = swapLargestValueLeftSub(root.getLeftChild()); //store node we are swapping
		
		TreeNode parentSwap = findParent(root, swapNode); //parent of node with highest value in left subtree
		
		
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
	
	
	public  TreeNode swapLargestValueLeftSub(TreeNode head){ //retrieves larget value in left subtree
		if(head.getRightChild() != null)
			head = swapLargestValueLeftSub(head.getRightChild());
		return head;
	}
	
	
	
	
	//returns parent of 2nd paramter
	public  TreeNode findParent(TreeNode head, TreeNode target){//2nd parameter is who's parent we are looking for
		if(head.getLeftChild() == target || head.getRightChild() == target)
			return head;
		 
		
		if(target.getData() <= head.getData()) //if the lookup value is smaller than or equal to the head
			head = findParent(head.getLeftChild(),target); //lookup the left subtree
		else
			 head = findParent(head.getRightChild(), target); //otherwise lookup the right subtree
		return head;
		
		
	}
	
	public  void removeNode(TreeNode head,TreeNode target){ // deletes the node we are searching for 
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
	
	
	
	public  TreeNode lookUp(TreeNode head, int data){
		if(head == null)
			return null; //base case, if the head null the node has not been found; return null
		
		if(head.getData() == data) //check if the value of the head matches the value were looking up, 
			return head;			//if yes then we've found a match
			
		
		if(data <= head.getData()) //if the lookup value is smaller than or equal to the head
			return lookUp(head.getLeftChild(),data); //lookup the left subtree
		else
			 return lookUp(head.getRightChild(), data); //otherwise lookup the right subtree
	
	}
	

}
class TreeNode {
	
	

	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(int data){
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	
}