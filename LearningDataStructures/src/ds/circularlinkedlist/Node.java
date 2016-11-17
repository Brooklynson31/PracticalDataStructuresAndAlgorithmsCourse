package ds.circularlinkedlist;

public class Node {

	/* First linked list assignment--> create the Node class */
	
	 public Node next;
	public int data;
	
	public Node()
	{
		
		this.next = null;
	}
	
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
	
	public void displayNode(){
		System.out.println("[" + data + "]");
	}
	
}
