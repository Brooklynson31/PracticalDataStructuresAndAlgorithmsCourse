package ads.binarytree;

public class InOrderDepthFirstTraversal {

	public static void main(String[] args) {

		Node<Character> a = new Node<>('A');
		Node<Character> b = new Node<>('B');
		Node<Character> c = new Node<>('C');
		Node<Character> d = new Node<>('D');
		Node<Character> e = new Node<>('E');
		Node<Character> f = new Node<>('F');
		Node<Character> g = new Node<>('G');
		Node<Character> h = new Node<>('H');
		
		a.setLeftChild(b);
		a.setRightChild(c);
		c.setLeftChild(d);
		c.setRightChild(e);
		d.setLeftChild(f);
		d.setRightChild(h);
		e.setRightChild(g);
		
		inOrder(a);
	}
	//Shoud print b-A-f-d-h-c-e-g
	public static void inOrder(Node <Character> root){
		if(root == null) return;
		
		inOrder(root.getLeftChild());
		System.out.println(root.getData());
		inOrder(root.getRightChild());
	}

}
