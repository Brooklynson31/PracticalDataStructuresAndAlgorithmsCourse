package ds.doublylinkedlist;

public class Node {

	/* First linked list assignment--> create the Node class */
	
	 public Node next;
	 public Node prev;
	 public int data;
	
	public Node()
	{
		
		this.next = null;
	}
	
	public Node(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public void displayNode(){
		System.out.println("[" + data + "]");
	}
	
}
