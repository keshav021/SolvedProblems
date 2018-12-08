import java.io.*;
import java.util.*;

public class DFS{
	int V;
	List<Integer> adjList[];
	DFS(int V){
		this.V =V;
		adjList = new ArrayList[V];
		for(int i=0;i<V;i++){
			adjList[i]=new ArrayList<>();
		}
	}

	public static void addEdge(DFS g, int src, int dest){
		g.adjList[src].add(dest);
		//g.adjList[dest].add(src);
	}

	public static void DFS_Traversal(DFS g, int src, int [] color){
		color[src]=1;
		List<Integer> al = g.adjList[src];
		for(int i=0;i<al.size();i++){
			if(color[al.get(i)]==0){
				System.out.print(al.get(i)+" ");
				DFS_Traversal(g,al.get(i),color);
				
			}
		}
		color[src]=2;
	}

	public static void main(String args[]){
		int V = 5; 
        DFS graph= new DFS(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
       // addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
      //  addEdge(graph, 2, 3); 
       // addEdge(graph, 3, 4); 
       	int[] color = new int[V];
       	Arrays.fill(color,0);
       	for(int i=0;i<V;i++){
       		if(color[i]==0){
       			System.out.print(i+" ");
       			DFS_Traversal(graph,i,color);
       			
       		}
       	}
	}
}