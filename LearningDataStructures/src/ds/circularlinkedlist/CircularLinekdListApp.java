package ds.circularlinkedlist;


public class CircularLinekdListApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	


		/* fourth linked list assignment--> make a circular linked list*/
		CircularLinkedList list = new CircularLinkedList();
		list.insertFirst(5);
		list.insertFirst(8);
		list.insertFirst(7);
		list.insertFirst(2);
		list.insertLast(11);
		list.displayList();
		list.deleteNode().displayNode();

		

	}
	
}
