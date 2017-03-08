package ads.binarytree;

public class CountTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int countTrees(int numNodes){
		if(numNodes <= 1) return 1; //when the number of Nodes is 1, there is just 1 possible tree - 
									//this is the base case
		
		int sum = 0;
		for(int i = 1; i <= numNodes;i++){ //consider that every node can be the root
			//The nodes before it will be on the left and the nodes after on the right
			int countLeftTrees  =  countTrees(i-1); 
			int countRightTrees = countTrees(numNodes - i); //Nodes on the left and right form their own subtrees
			
			sum = sum + (countLeftTrees * countRightTrees); //This is the number of possible trees with this root-->the combination right and left subtrees
		}
		
		
		
		return sum;
	}

}
