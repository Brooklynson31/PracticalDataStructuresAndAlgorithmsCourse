package ds.linkedlist;

import ds.doublylinkedlist.Node;

public class SingleLinkedList {
	private Node first;	
	
	
	
	public SingleLinkedList(){
		
	}
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int link){
		Node newNode = new Node();
		newNode.data = link;
		newNode.next = first;

		first = newNode;
	}
	
	public Node deleteFirstNode(){
		Node temp = first;
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
	
		Node currentNode = first;
		while(currentNode.next != null){
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		
	}
}
