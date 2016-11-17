package ds.circularlinkedlist;

import ds.doublylinkedlist.Node;

public class CircularLinkedList {
	private Node first;
	private Node last;
	
	
	
	
	public CircularLinkedList(){
		
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int link){
		Node newNode = new Node();
		newNode.data = link;
		if(isEmpty()){
			last = newNode;
		}
		newNode.next = first;

		first = newNode;
	}
	
	public Node deleteNode(){
		Node temp = first;
		if(first.next == null){ //checks if first is only node in the list
			last = null;
		}
		first = first.next;
		
		return temp;
	}
	
	public void displayList(){
		Node currentNode = first;
		while(currentNode != null){
			currentNode.displayNode();
			currentNode = currentNode.next;
		}
	}
	
	public void insertLast(int link){
		Node newNode = new Node();
		newNode.data = link;
		if(isEmpty()){ //checks if there are any Nodes in list and if not assigns first to New Node being inserted
			first = newNode;
		}
		last.next = newNode;
		last = newNode;
		
	}
}
