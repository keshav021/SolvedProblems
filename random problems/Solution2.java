
//Dijkstra's Algo

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
        //if(g.adjList[src].get(new Edge(dest)))
        Edge e1 = new Edge(dest,weight);
        Edge e2 = new Edge(src,weight);
        int flag=0;
        for(Edge e:g.adjList[src]){
            if(e.dest==dest&&e.weight>=weight){
                g.adjList[src].set(g.adjList[src].indexOf(e),e1);
                flag=1;
                break;        
            }
        }
        if(flag==0){
            g.adjList[src].add(e1);
        }
        flag=0;
        for(Edge e:g.adjList[dest]){
            if(e.dest==src&&e.weight>=weight){
                g.adjList[dest].set(g.adjList[dest].indexOf(e),e2);
                flag=1;
                break;        
            }
        }
        if(flag==0){
            g.adjList[dest].add(e2);
        }
       /* if(g.adjList[src].get(e1)==-1){
            //g.adjList[src].add(e1);    
        }
        else{
            check_duplicate(g,src,dest,weight);    
        }
        if(g.adjList[dest].get(e2)!=-1)
*/
        
        
        //g.adjList[dest].add(new Edge(src,weight));
    }

    public void check_duplicate(Graph g, int src,int dest,int weight){
        /*for(Edge e:g.adjList[src]){
            if(e.dest==dest&&e.weight>weight){
                e.weight=weight;
            }
        }*/
        Iterator<Edge> itr = g.adjList[src].iterator();
        int flag=0;
        Edge e=null;
        while(itr.hasNext()){
            e  = itr.next();
            if(e.dest==dest&&e.weight>weight){
                flag=1;
                break;
            }
        }
       // int index=g.adjList[src].indexOf(e);
        g.adjList[src].set(g.adjList[src].indexOf(e),new Edge(dest,weight));

    }
}

class MyComparator implements Comparator<Vertex>{
    public int compare(Vertex v1, Vertex v2){
        return (v1.weight-v2.weight); 
    }
}

public class Solution2{
    
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while(t-->0){
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
            int path[] = new int[V+1];
            Arrays.fill(path,Integer.MAX_VALUE);
            color[src]=1;path[src]=0;
            int sum=0;
            while(!pq.isEmpty()){
                Vertex temp = pq.poll();
                ArrayList<Edge> edgeList=g.adjList[temp.name];
                color[temp.name]=2;
                for(Edge e:edgeList ){
                    if(color[e.dest]==0){
                        color[e.dest]=1;
                        path[e.dest]=path[temp.name]+e.weight;
                        pq.add(new Vertex(e.dest,e.weight+path[temp.name]));
                        //sum = sum+e.weight;
                    }
                    else if(color[e.dest]==1){
                       // 
                        if(path[e.dest]>e.weight+path[temp.name]){
                            pq.remove(new Vertex(e.dest,path[e.dest]));
                          // sum = sum - path[e.dest];
                            pq.add(new Vertex(e.dest,e.weight+path[temp.name]));
                            path[e.dest]=e.weight+path[temp.name];
                            //sum = sum+path[e.dest];
                        }
                        
                    }
                }
                
            }
            
            for(int j=1;j<path.length;j++){
                //sum = sum+i;
                int i =path[j];
                if(j==src){
                    continue;
                }
                else if(i==Integer.MAX_VALUE){
                    System.out.print(-1+" ");
                }
                else{
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }
        //System.out.println(sum);
        
    }
}