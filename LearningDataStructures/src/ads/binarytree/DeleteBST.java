package ads.binarytree;



public class DeleteBST {
	

	public static void main(String[] args) {
			TreeNode<Integer> z = new TreeNode<>(5);
		 TreeNode<Integer> a = new TreeNode<>(13);
	      TreeNode<Integer> b = new TreeNode<>(5);
	      TreeNode<Integer> c = new TreeNode<>(18);
	      TreeNode<Integer> d = new TreeNode<>(15);
	      TreeNode<Integer> e = new TreeNode<>(27);
	      TreeNode<Integer> f = new TreeNode<>(14);
	      TreeNode<Integer> g = new TreeNode<>(30);
	      TreeNode<Integer> h = new TreeNode<>(17);
	      TreeNode<Integer> x = new TreeNode<>(3);
	      TreeNode<Integer> bb = new TreeNode<>(10);


	
		a.setLeftChild(b);
		a.setRightChild(c);
		b.setLeftChild(x);
		b.setRightChild(bb);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
		
		delete(a,3);

	

	}
	
	//Main method in Delete node process
	public static TreeNode<Integer> delete(TreeNode<Integer> root, int target){

		if(root == null) return null;
		
		TreeNode<Integer> targetNode = new TreeNode<>(target);
		
		TreeNode<Integer> nodeToBeDeleted = lookUp(root,targetNode.getData()); //search for node to be deleted
		
		if(nodeToBeDeleted == null) return null; //node we want to delete does not exist in tree
		
		if(root == nodeToBeDeleted){ //node we are deleting is a root node
			root = deleteRootNode(root);

		} else {
		
			TreeNode<Integer> deleteParent = findParent(root,nodeToBeDeleted); //find parent nsearch forode of node to be deleted and keep track of it
			
			
			
			//check how many children the node to be deleted has
			if(nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() != null){ //node to be dleted has 2 children
					//store the nodes that represent left and right subtrees of the node to be deleted
					TreeNode<Integer> deleteNodeLeftChild =  nodeToBeDeleted.getLeftChild(); //root node in left subtree of node to be deleted
					TreeNode<Integer> deleteNodeRightChild =  nodeToBeDeleted.getRightChild(); //root node in right subtree of node to be deleted
				
					//search for the biggest node in the left subtree of the node to be deleted
					TreeNode<Integer> replaceNode = swapLargestValueLeftSub(nodeToBeDeleted.getLeftChild()); //store node we are swapping
				
					TreeNode<Integer> replaceParent = findParent(root, replaceNode); //parent of node with highest value in left subtree
				
				
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

	private static TreeNode<Integer> deleteRootNode(TreeNode<Integer> root) {
		//store the nodes that represent left and right subtrees of the node to be deleted
		TreeNode<Integer> rootNodeLeftChild =  root.getLeftChild(); //root node in left subtree of node to be deleted
		TreeNode<Integer> rootNodeRightChild =  root.getRightChild(); //root node in right subtree of node to be deleted

		//search for the biggest node in the left subtree of the node to be deleted
		TreeNode<Integer> swapNode = swapLargestValueLeftSub(root.getLeftChild()); //store node we are swapping
		
		TreeNode<Integer> parentSwap = findParent(root, swapNode); //parent of node with highest value in left subtree
		
		
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
	
	
	public static TreeNode<Integer> swapLargestValueLeftSub(TreeNode<Integer> head){ //retrieves larget value in left subtree
		if(head.getRightChild() != null)
			head = swapLargestValueLeftSub(head.getRightChild());
		return head;
	}
	
	
	
	
	//returns parent of 2nd paramter
	public static TreeNode<Integer> findParent(TreeNode<Integer> head, TreeNode<Integer> target){//2nd parameter is who's parent we are looking for
		if(head.getLeftChild() == target || head.getRightChild() == target)
			return head;
		 
		
		if(target.getData() <= head.getData()) //if the lookup value is smaller than or equal to the head
			head = findParent(head.getLeftChild(),target); //lookup the left subtree
		else
			 head = findParent(head.getRightChild(), target); //otherwise lookup the right subtree
		return head;
		
		
	}
	
	public static void removeNode(TreeNode<Integer> head,TreeNode<Integer> target){ // deletes the node we are searching for 
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
	
	
	
	public static TreeNode<Integer> lookUp(TreeNode<Integer> head, int data){
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
class TreeNode<T> {
	
	

	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	public TreeNode(T data){
		this.data = data;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild;
	}
}


