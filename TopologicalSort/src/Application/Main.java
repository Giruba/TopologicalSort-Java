package Application;

import java.util.Scanner;
import Graph.Graph;

public class Main {
	public static void main(String[] args) {
		System.out.println("Topological sort");
		System.out.println("----------------");
		
		try {
			System.out.println("Enter the number of nodes in the graph");
			Scanner scanner = new Scanner(System.in);
			int vertexCount = scanner.nextInt();
			Graph graph = new Graph(vertexCount);
			for(int index = 0; index < vertexCount; index++) {
				System.out.println("Enter the number of adjacency vertices for this vertex "+index);
				int adjVertexCount = scanner.nextInt();
				for(int adjVertexIndex = 0; adjVertexIndex < adjVertexCount; adjVertexIndex++) {
					System.out.println("Enter the adjacency vertex");
					int adjVertex = scanner.nextInt();
					graph.AddVertexToCorrespondingAdjacencyList(index, adjVertex);
				}
			}
			graph.TopologicalSort();
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
}
