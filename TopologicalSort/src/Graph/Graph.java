package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int numberOfVertices;
	private LinkedList<Integer> []adjacencyList;
	
	public Graph(int vertices) {
		this.numberOfVertices = vertices;
		adjacencyList = new LinkedList[vertices];
		for(int index = 0; index < this.numberOfVertices; index++) {
			adjacencyList[index] = new LinkedList();
		}
	}
	
	public void SetVertices(int value) {
		this.numberOfVertices = value;
	}
	
	public void SetAdjacenyList(LinkedList<Integer> []adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
	public int GetNumberOfVertices() {
		return this.numberOfVertices;
	}
	
	public LinkedList<Integer>[] GetAdjacencyList(){
		return adjacencyList;
	}
	
	public void TopologicalSort() {
		int[] visited = new int[this.numberOfVertices];
		Stack<Integer> stack = new Stack<Integer>();
		for(int index = 0; index < this.numberOfVertices; index++) {
			if(visited[index] == 0) {
				_TopologicalSortutil(index, visited, stack);
			}
		}
		while(stack.size() != 0 ) {
			System.out.println(stack.pop());
		}
	}
	
	public void _TopologicalSortutil(int vertex, int[] visited, Stack<Integer> stack) {
		visited[vertex] = 1;
		
		int sizeOfAdjacencyList = this.adjacencyList[vertex].size();
		LinkedList<Integer> adjList = this.adjacencyList[vertex];
		Iterator<Integer> listIterator = adjList.iterator();
		
		while(listIterator.hasNext()) {
			if(visited[listIterator.next()] == 0) {
				_TopologicalSortutil(listIterator.next(), visited, stack);
			}
		}
		
		stack.push(vertex);
	}
	
	public void AddVertexToCorrespondingAdjacencyList(int sourceVertex, int destinationVertex) {
		this.adjacencyList[sourceVertex].add(destinationVertex);
	}
}
