package ds.graph;

public class LinkedListGraph {
	
	Vertex[] arrayOfLists;
	int indexCounter = 0;
	boolean undirected = true;
	
	private class Node{
		public Node next; //points to next Instance of Node
		public int vertexIdx; //adjacent vertexes slot position in the array
		
		public Node(int vertexIdx, Node node){
			this.vertexIdx = vertexIdx;
			next = node;
			
		}
	}
	
	private class Vertex {
		String name;
		Node adjlist; //list of Nodes
		Vertex(String name, Node aNode){
		this.name = name;
		this.adjlist = aNode;
		}
	}
	
	public LinkedListGraph( int vCount, String graphType){
		if(graphType.equals("directed")){
			undirected = false;
		}
		arrayOfLists = new Vertex[vCount];
		
	}
	public void addVertex(String vertexName) {
		arrayOfLists[indexCounter] = new Vertex(vertexName,null); //instantiating new Vertex objcet and assigning to one of the slots in the array
		indexCounter++;
		
	}
	public void addEdge(String srcVertexName, String desVertexName) {
		int v1Idx = indexForName(srcVertexName);
		int v2Idx = indexForName(desVertexName);
		//at src vertex index position in array we are assigning to its list of Nodes a new node
		arrayOfLists[v1Idx].adjlist = new Node(v2Idx, arrayOfLists[v1Idx].adjlist); //index position of destination Node and assigns next variable to point to list of nodes of source index
		if(undirected){
			arrayOfLists[v2Idx].adjlist = new Node(v1Idx, arrayOfLists[v2Idx].adjlist);
		}
		
	}
	private int indexForName(String name) { //looks through array in which all vertices exists and find index position for given name, Src vertex and destination vertex
		for(int v =0; v < arrayOfLists.length;v++){
			if(arrayOfLists[v].name.equals(name)){ //get index number of where vertices are in array
			return v;
			} 
		}
		return -1;
	}
	public void print() {
		System.out.println();
		for(int v = 0; v < arrayOfLists.length;v++){ //loop through array of Lists (each of vertice)
			System.out.println(arrayOfLists[v].name); //getting name of vertice
			for(Node aNode = arrayOfLists[v].adjlist; aNode != null; aNode = aNode.next){ //for vertex get list of Nodes
				System.out.println("--> " + arrayOfLists[aNode.vertexIdx].name); //print it out
			}
			System.out.println("\n");
		}
		
	}

}
