import java.util.LinkedList;
import java.util.PriorityQueue;
public class CheckUniqueMST {
		static class Entry implements Comparable<Entry>
		{
		    private int key;
		    private int value;
		    public Entry(int key, int value) {
		        this.key = key;
		        this.value=value;
		    }
		    // getters
		    public int getKey()
		    {
		    	return this.key;
		    }
		    public int getValue() 
		    {
				return value;
			}
			@Override
		    public int compareTo(Entry other) {
		        return Integer.compare(this.getValue(),other.getValue());
		    }
			@Override
			public boolean equals(Object o){
			    if(o instanceof Entry)
			    {
			      Entry c = (Entry)o;
			      return key == c.key;
			    }
			    return false;
			}
		}
		static class Graph 
		{ 
			int V; 
			LinkedList<Entry>[] adjList;
			Graph(int n) 
			{ 
				V=n+1; 
				adjList= new LinkedList[V];
				for(int i=1;i<V;i++){ 
					adjList[i] = new LinkedList<>();
				} 
			} 
		} 
		static void addEdge(Graph graph, int src, int dest,int wt) 
		{ 
			Entry e1= new Entry(dest, wt);
			graph.adjList[src].add(e1);
			Entry e2= new Entry(src, wt);
			graph.adjList[dest].add(e2);
		} 
		public static void prims( int s, Graph g)
		{
			PriorityQueue<Entry> q= new PriorityQueue<Entry>();
			Entry u;
			int[] p= new int [g.V];
			char[] color= new char [g.V];
			int[] parent= new int [g.V];
			for (int i = 1; i < g.V; i++)
			{
				p[i]=Integer.MAX_VALUE;
				color[i]='R';
			}
			p[s]=0;
			parent[s]=s;
			color[s]='B';
			q.add(new Entry(s,0));
			while(!q.isEmpty())
			{
				u=q.poll();
				color[u.key]='G';
				for(Entry v: g.adjList[u.key])
				{
					if(color[v.key]=='R')
					{
						p[v.key]=v.value;
						parent[v.key]=u.key;
						q.add(v);
						color[v.key]='B';
					}
					else
					{
						if((color[v.key]=='B') && (p[v.key]>v.value))
						{
							p[v.key]=v.value;
							parent[v.key]=u.key;
							//decrease key
							q.remove(v);
							q.add(v);
						}
					}
				}
			}
			System.out.println("Minimum Spanning tree of the graph: ");
			System.out.println("Parent -> Node -> Distance");;
			for (int i = 1; i < g.V; i++)
			{
				System.out.println(parent[i]+" -> "+i+" -> "+p[i]);
			}
			boolean chk=true;
			for (int i = 1; i < g.V; i++)
			{
				int wt=p[i];
				int x=parent[i];
				for(int v=1;v<g.V;v++) 
				{ 
					for(Entry adjNode: g.adjList[v])
					{ 
						if(adjNode.key==i && v!=x && adjNode.value==wt)
						{
							System.out.println("MST is not unique");
							chk=false;
							break;
						}
					}
					if(chk==false)
						break;
				}
				if(chk==false)
					break;
			}
			if(chk==true)
				System.out.println("MST is unique");
		}
		static void printGraph(Graph graph) 
		{	 
			for(int v=1;v<graph.V;v++) 
			{ 
				System.out.println("Adjacency list of vertex "+ v); 
				System.out.print("head"); 
				for(Entry adjNode: graph.adjList[v]){ 
					System.out.print(" -> "+adjNode.key); 
				} 
				System.out.println("\n"); 
			} 
		} 
		public static void main(String args[]) 
		{  
			int V=4;
			Graph graph = new Graph(V);
			// Example1
			//int V=5;
//			addEdge(graph,1,2,8);
//			addEdge(graph,2,3,4); 		 
//			addEdge(graph,3,4,4);
//			addEdge(graph,4,5,3);
//			addEdge(graph,5,6,2);
//			addEdge(graph,1,2,4);
//			addEdge(graph,1,7,5);
//			addEdge(graph,5,7,4);
//			addEdge(graph,2,4,1);
			//Example 2
			//int  V=5;
//			addEdge(graph,1,2,1);
//			addEdge(graph,1,4,4);
//			addEdge(graph,1,5,3);
//			addEdge(graph,2,4,4);
//			addEdge(graph,2,5,2);
//			addEdge(graph,4,5,4);
//			addEdge(graph,3,5,4);
//			addEdge(graph,3,6,5);
//			addEdge(graph,5,6,7);
			//Example 3
			addEdge(graph,1,2,1);
			addEdge(graph,2,3,1);
			addEdge(graph,3,4,1);
			addEdge(graph,1,4,1);
			addEdge(graph,1,3,1);
			addEdge(graph,2,4,1);
			/*addEdge(graph,1,5,5);
			addEdge(graph,4,8,8);
			addEdge(graph,3,7,7);
			addEdge(graph,2,6,6);
			addEdge(graph,5,6,10);
			addEdge(graph,6,7,10);
			addEdge(graph,7,8,10);
			addEdge(graph,5,8,10);
			*/
			printGraph(graph);
			prims(1, graph);
			
		} 
}
