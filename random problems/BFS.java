import java.io.*;
import java.util.*;

public class BFS{
	int V;
	List<Integer> adjList[];

	BFS(int V){
		this.V = V;
		adjList = new ArrayList[V];
		for(int i=0;i<V;i++){
			adjList[i] = new ArrayList<>();
		}
	}

	public static void addEdge(BFS g, int src, int dest){
		g.adjList[src].add(dest);
		g.adjList[dest].add(src);
	}

	public static void BFSTraversal(BFS g, int src, boolean[] visited){
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		visited[src]=true;
		while(!q.isEmpty()){
			int v = q.poll();
			System.out.print(v+" ");
			List<Integer> al = g.adjList[v];
			for(int i=0;i<al.size();i++){
				
				int temp_v = al.get(i);
				if(!visited[temp_v]){
					visited[temp_v]=true;
					q.add(temp_v);	
				}
				
			}
		}
	}

	public static void main (String args[]){
		int V = 5; 
        BFS graph= new BFS(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
       	boolean[] visited = new boolean[V];
       	for(int i=0;i<V;i++){
       		if(!visited[i])
       			BFSTraversal(graph,i,visited);	
       	}
       	
        
	} 	
}