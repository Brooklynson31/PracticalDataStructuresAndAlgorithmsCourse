package ds.linkedlist;

import ds.doublylinkedlist.Node;
import ds.linkedlist.SingleLinkedList;

public class SingleLinkedListApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/* First linked list assignment--> create the Node class */
		Node nodeA = new Node(3);
		Node nodeB = new Node(7);
		Node nodeC = new Node(8);
		Node nodeD = new Node(9);
		
		/* second linked list assignment--> link the Nodes */
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;

		/* third linked list assignment--> make a method that returns the number of nodes in list*/

		System.out.println(listLength(nodeA));
		System.out.println(listLength(nodeB));
		System.out.println(listLength(nodeC));
		System.out.println(listLength(nodeD));

		/* fourth linked list assignment--> make a single linked list that can add to back of the lists*/
		SingleLinkedList list = new SingleLinkedList();
		list.insertFirst(5);
		list.insertFirst(8);
		list.insertFirst(7);
		list.insertFirst(2);
		list.insertLast(11);
		list.displayList();

		

	}
	

	public static int listLength(Node cNode){
		int numOfNodes = 1;
		while(cNode.next != null){
			cNode = cNode.next;
			numOfNodes++;
		}
	
		return numOfNodes;
				
	}
	


}
