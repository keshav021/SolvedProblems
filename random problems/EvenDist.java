/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Graph {
	
	
	    int V;
	    List<Integer> adjList[];
	    static int ecount=0;
	    static int ocount=0;
	    Graph(int V){
	        adjList = new ArrayList[V+1];
	        for(int i=0;i<=V;i++){
	            adjList[i] = new ArrayList<>();
	        }
	    }
	    
	    static void addEdge(Graph g, int src, int dest){
	        g.adjList[src].add(dest);
	        g.adjList[dest].add(src);
	    }
	    
	    static void DFS(Graph g ,int dist,int src,boolean[] visited){
	        List<Integer> al = g.adjList[src];
	        if(dist>0&&dist%2==0){
	            ecount++;
	        }
	        else if(dist>0){
	            ocount++;
	        }
	        for(int i=0;i<al.size();i++){
	            if(! visited[al.get(i)]){
	                visited[al.get(i)]=true;
	                DFS(g,++dist,al.get(i),visited);
	                // DFS(g,0,al.get(i));
	            }
	        }
	    }
	    
	    static void solve(Graph g,int src, boolean[] visited){
	        visited[src]=true;
	        DFS(g,0,src,visited);
	    }
	
	
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    ecount=0;ocount =0;
		    int V = Integer.parseInt(br.readLine());
		    Graph g = new Graph(V);
		    String s[] = br.readLine().split(" ");
		    int k=0;
		    for(int i=1;i<V;i++){
		        int src = Integer.parseInt(s[k++]);
		        int dest = Integer.parseInt(s[k++]);
		        addEdge(g,src,dest);
		    }
		    boolean visited[] = new boolean[V+1];
		    int dist=0;
		    solve(g,Integer.parseInt(s[0]),visited);
		    System.out.println( (ecount*(ecount-1))/2+(ocount*(ocount-1))/2 );
		}
	}
}