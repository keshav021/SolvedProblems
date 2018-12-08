import java.util.*;
import java.io.*;

public class Graph{
	int V;
	List<Integer> adjList[];
	Graph(int V){
		this.V = V;
		adjList = new ArrayList[V];
		for(int i=0;i<V;i++){
			adjList[i] = new ArrayList<>();
		}
	}

	public static void addEdge(Graph g, int src , int dest){
		g.adjList[src].add(dest);
		g.adjList[dest].add(src);
	}

	public static void printGraph(Graph g){
		for(int i=0;i<g.V;i++){
			List<Integer> al = g.adjList[i];
			System.out.print(i);
			for(int j=0;j<al.size();j++){
				System.out.print(" ->"+al.get(j));
			}
			System.out.println();
		}
	}

	public static void main (String args[]){
		int V = 5; 
        Graph graph = new Graph(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        printGraph(graph); 
	} 
}