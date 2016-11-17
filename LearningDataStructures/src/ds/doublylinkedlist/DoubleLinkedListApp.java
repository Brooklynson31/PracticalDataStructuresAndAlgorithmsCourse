package ds.doublylinkedlist;


public class DoubleLinkedListApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		DoubleLinkedList thelist = new DoubleLinkedList();
		thelist.insertFirst(22);
		thelist.insertFirst(44);
		thelist.insertFirst(66);
		thelist.insertLast(11);
		thelist.insertLast(33);
		thelist.insertLast(55);
		thelist.displayforward();
		thelist.displayBackward();
		thelist.removeFirstNode();
		thelist.removeLastNode();
		thelist.deleteKey(11);
		thelist.displayforward();
		thelist.insertAfter(22, 77);
		thelist.displayforward();

		thelist.insertAfter(33, 88);
		thelist.displayforward();
}
}
