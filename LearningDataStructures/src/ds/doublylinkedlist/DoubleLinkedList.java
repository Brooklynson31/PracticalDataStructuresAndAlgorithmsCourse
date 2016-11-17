package ds.doublylinkedlist;

public class DoubleLinkedList {
	private Node first;
	private Node last;
	
	
	
	public boolean isEmpty(){
		return (first == null);
	}
	
	public void insertFirst(int data){
		Node newNode = new Node();
		newNode.data = data;
		if(isEmpty()){
			last = newNode;
		}
		else{
			first.prev = newNode;
		}
		newNode.next = first;
		first = newNode;
	}
	
	public void insertLast(int data){
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()){
			first = newNode;
		}
		else{
			last.next = newNode; // assigning old last to newnode
			newNode.prev = last; // the old alst will be the newnodes previous
		}
		last = newNode;
	}
	
	public Node removeFirstNode(){
		Node temp = first;
		if(first.next == null){ // checks if there is only one item in list
			last = null;
		} else {
			first.next.prev = null; //the lists first node will point to null
		}
		
		first = first.next; //we are assigning the reference of the node following the old first node tot the first field in the linked list object
		return temp; //return deleted old first node
	}
	
	public Node removeLastNode(){
		Node temp = last;
		if(last.prev == null){ //if there is only one item in the list
			first = null;
		}
		else {
			last.prev.next = null; // the new last node in the list will point to null
		}
		
		last = last.prev; // reassign the last node in the list.
		return temp;
	}
	
	public boolean insertAfter(int key, int data){
		Node current = first; //we start from the beginning of the list
		while(current.data != key){
			current = current.next;
			if(current == null){
				return false;
			}
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(current == last){
			current.next = null;
			last = newNode;
		} else{
			newNode.next = current.next; //new nodes next field should point to the node ahead of the current one
			current.next.prev = newNode; //the node ahead of current, its previous field should point to the new node
		}	
		newNode.prev = current;
		current.next = newNode;
		
		
		return true;
	}
	
	//will delete after
	public Node deleteKey(int key){
		Node current = first; // start
		while(current.data != key){
			current = current.next;
			if(current == null){
				return null;
			}
		}
		
		if(current == first){ //make the first field point to the node foloowing current since current will be deleted.
			first = current.next;
		} else {
			current.prev.next = current.next;
		}
			
		if (current == last){
			last = current.prev;
	
		} else{
			current.next.prev = current.prev;
			
		}
	
		return current;
	}
	
	public void displayforward(){
		System.out.println("list(first --> last)");
		Node current = first;
		while(current != null){
			current.displayNode();
			current = current.next;
		}
		System.out.println();
	}
	public void displayBackward(){
		System.out.println("list(last --> first)");
		Node current = last;
		while(current != null){
			current.displayNode();
			current = current.prev;
		}
		System.out.println();
		
	}

}
