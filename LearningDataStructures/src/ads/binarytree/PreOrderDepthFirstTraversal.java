package ads.binarytree;

public class PreOrderDepthFirstTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Character> a = new Node<>('A');
		Node<Character> b = new Node<>('B');
		Node<Character> c = new Node<>('C');
		Node<Character> d = new Node<>('D');
		Node<Character> e = new Node<>('E');
		Node<Character> f = new Node<>('F');
		Node<Character> g = new Node<>('G');
//		Node<Character> h = new Node<>('H');
		
//		a.setLeftChild(b);
//		a.setRightChild(c);
//		c.setLeftChild(d);
//		c.setRightChild(e);
//		d.setLeftChild(f);
//		d.setRightChild(h);
//		e.setRightChild(g);
//		preOrder(a);
		
		a.setLeftChild(b);
		a.setRightChild(c);
//		b.setLeftChild(d);
//		b.setRightChild(e);
//		c.setLeftChild(f);
//		c.setRightChild(g);
		
		preOrder(a);
		


	}
	
	public static void preOrder(Node<Character> root){
		if(root == null) //base case -- Nothing to Traverse
			return;
		
		System.out.println(root.getData()); //process Node data
									//Process The Node before recursing to Left and Rigth subtrees
		preOrder(root.getLeftChild()); 
		preOrder(root.getRightChild());
	}

}
