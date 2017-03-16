package ads.binarytree;

public class PostOrderDepthFirstTraversal {

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
//		c.setLeftChild(d);
//		c.setRightChild(e);
//		d.setLeftChild(f);
//		d.setRightChild(h);
//		e.setRightChild(g);
		
		postOrder(a);
	}
	//Order should be: B-F-H-D-G-E-C-A
	public static void postOrder(Node<Character> root){
		if(root == null) return;
		
		postOrder(root.getLeftChild());
		postOrder(root.getRightChild());
		System.out.println(root.getData());
	}

}
