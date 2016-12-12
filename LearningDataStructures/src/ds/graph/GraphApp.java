package ds.graph;

public class GraphApp {

	public static void main(String[] args) {
		
		Graph myGraph = new Graph(5);
		myGraph.addEdge(0,1); //second number is an vertice that it is adjacent too
		myGraph.addEdge(0,2);//first number
		myGraph.addEdge(0,3);
		myGraph.addEdge(1,2);
		myGraph.addEdge(1,4);
		myGraph.addEdge(2,3);
		myGraph.addEdge(3,1);
		myGraph.addEdge(4,0);
		myGraph.addEdge(4,3);

		Object [] values = myGraph.adj(4);
		for(Object val : values){
		System.out.println(val);
		}
		//design a better grapgh
		LinkedListGraph newGraph = new LinkedListGraph(5, "directed");
		newGraph.addVertex("State");
		newGraph.addVertex("Avenel");
		newGraph.addVertex("Elm");
		newGraph.addVertex("Pocono");
		newGraph.addVertex("William");
		
		newGraph.addEdge("Avenel", "Pocono");
		newGraph.addEdge("State", "Elm");
		newGraph.addEdge("Elm", "Avenel");
		newGraph.addEdge("Elm", "William");
		newGraph.addEdge("William", "State");
		newGraph.addEdge("William", "Pocono");
		newGraph.addEdge("Pocono", "Elm");
		newGraph.addEdge("State", "Avenel");
		
		newGraph.print();


		

		
	}



}
