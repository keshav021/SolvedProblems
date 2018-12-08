
//Prims Algo

import java.io.*;
import java.util.*;


 class Edge{
    //int src;
    int dest;
    int weight;
    Edge(int dest, int weight){
        //this.src = src;
        this.dest= dest;
        this.weight = weight;
    }
}
class Vertex{
    int name;
    int weight;
    Vertex(){

    }
    Vertex(int name, int weight){
        this.name=name;
        this.weight=weight;
    }
}

 class Graph{
    int V;
    ArrayList<Edge> adjList[];
    Graph(int V){
        this.V =V;
        adjList = new ArrayList[V+1];
        for(int i=0;i<=V;i++){
            adjList[i]= new ArrayList<Edge>();
        }
    }

    public void addEdge(Graph g, int src, int dest, int weight){
        g.adjList[src].add(new Edge(dest,weight));
        g.adjList[dest].add(new Edge(src,weight));
    }
}

class MyComparator implements Comparator<Vertex>{
    public int compare(Vertex v1, Vertex v2){
        return (v1.weight-v2.weight); 
    }
}

public class Solution{
    
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        Graph g = new Graph(V);
        int E = Integer.parseInt(s[1]);
        for(int i=0;i<E;i++){
            String s1[] = br.readLine().split(" ");
            g.addEdge(g,Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s1[2]));
        
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>(new MyComparator());
        int src = Integer.parseInt(br.readLine());
        Vertex v1= new Vertex(src,0);
        pq.add(v1);
        
        int color[]=  new int[V+1];
        int path[] = new int[V+1];path[src]=0;
        color[src]=1;
        int sum=0;
        while(!pq.isEmpty()){
            Vertex temp = pq.poll();
            ArrayList<Edge> edgeList=g.adjList[temp.name];
            color[temp.name]=2;
            for(Edge e:edgeList ){
                if(color[e.dest]==0){
                    color[e.dest]=1;
                    path[e.dest]=e.weight;
                    pq.add(new Vertex(e.dest,e.weight));
                    sum = sum+e.weight;
                }
                else if(color[e.dest]==1){
                   // 
                    if(path[e.dest]>=e.weight){
                        pq.remove(new Vertex(e.dest,path[e.dest]));
                       sum = sum - path[e.dest];
                        pq.add(new Vertex(e.dest,e.weight));
                        path[e.dest]=e.weight;
                        sum = sum+path[e.dest];
                    }
                    
                }
            }
            
        }
        
        /*for(int i:path){
            sum = sum+i;
        }*/
        System.out.println(sum);
        
    }
}