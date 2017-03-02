package ads.binarytree;

public class CountInternalNodes {

	public static void main(String[] args) {
		
		Node<Character> a = new Node<>('A');
		Node<Character> b = new Node<>('B');
		Node<Character> c = new Node<>('C');
		Node<Character> d = new Node<>('D');
		Node<Character> e = new Node<>('E');
		Node<Character> f = new Node<>('F');
		Node<Character> g = new Node<>('G');

		a.setLeftChild(b);
		a.setRightChild(c);
		b.setLeftChild(d);
		b.setRightChild(e);
		c.setLeftChild(f);
		c.setRightChild(g);
		
		System.out.println(fun(a));
	}
	
	public static int fun(Node<Character> root){
		if(root == null) return 0;
		
		if(root.getLeftChild() == null && root.getRightChild() == null)
			return 0;
		return 1 + fun(root.getLeftChild()) + fun(root.getRightChild());
		
		
	}
	

}
