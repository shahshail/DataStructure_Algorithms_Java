/*
- Hello there.. This is the DFS(Depth-First Seearch) Graph traversal...
- Tree is considered as a graph bu the only difference is that the tree doent contain cycle but graphs do.
- To avoid processing a node more than once, we use a BOOLEAN VISITED Tree.
- This example is contain/use Adjacency List method for graph. YOu can also use Adjacency Matrics for this solution
**/
import java.util.*;
import java.util.ArrayList;
public class Graph_DFS{

//Here is the main class
public static void main(String[] args)
{
  System.out.println("Hello World from Graph_DFS...");
  Graph_Node graph = new Graph_Node(5);
  graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        System.out.println("This is Recusrsive Approach of Graph traversal..");
        graph.DFS_RECURSIVE(2);
        System.out.println("This is Iterative approach of Graph ");
        graph.DFS_Iterative(2);
}
}


// This is Graph class on Adjacency List
class Graph_Node{
  private int v;
  private int e;
  private LinkedList<Integer> adj[];

  public Graph_Node(int size)
  {
    v = size;
    adj = new LinkedList[size];
    for(int i = 0; i < adj.length; i++)
    {
      adj[i] = new LinkedList();
    }
  }

  public void addEdge(int vertices, int edges)
  {
    if(vertices > v) return;
    adj[vertices].add(edges);
    e++;
  }

//---------------------------- RECURSIVE IMPLIMENTATION OF DFS -----------------------------------
  public void DFS_RECURSIVE(int startVertices){
    // Mark all the vertices as false that are not visited..
    boolean visited[] = new boolean[v];

  //Call DFS Helper funtion (dfsUtil) recursively to print DFS traversal
    dfsUtil(startVertices, visited);
  }

  void dfsUtil(int v, boolean visited[])
  {
    //Lets mark the current node as a visited and print it.
    visited[v] = true;
    System.out.println(" " + v);

    //Recursive for all the vertices adjacent to this vertex
    Iterator<Integer> i = adj[v].listIterator();
    while(i.hasNext())
    {
      int n = i.next();
      if (!visited[n]) {
        dfsUtil(n, visited);
      }
    }
  }

//--------------------------------- ITERATIVE IMPLEMENTATION OF DFS -----------------------------------------------
/** This method is an iterative approach for DFS.
1) Internally mark all the vertices are not visited and create a stack for DFS.
2) Push the source node in it.
3) Loop until stack is not empty..
 - Pop the top node of the stack s and check weather s is visited or not, if it is not visited then we pring the node and mark as visited.
 - Traverse through the entire adjacency list of s, if we get a non visited node, we push it into stack.

 Lets start.
*/


// prints all not yet visited vertices reachable from s
       void DFS_Iterative(int s)
       {
           // Initially mark all vertices as not visited
           Vector<Boolean> visited = new Vector<Boolean>(v);
           for (int i = 0; i < v; i++)
               visited.add(false);

           // Create a stack for DFS
           Stack<Integer> stack = new Stack<>();

           // Push the current source node
           stack.push(s);

           while(stack.empty() == false)
           {
               // Pop a vertex from stack and print it
               s = stack.peek();
               stack.pop();

               // Stack may contain same vertex twice. So
               // we need to print the popped item only
               // if it is not visited.
               if(visited.get(s) == false)
               {
                   System.out.print(s + " ");
                   visited.set(s, true);
               }

               // Get all adjacent vertices of the popped vertex s
               // If a adjacent has not been visited, then puah it
               // to the stack.
               Iterator<Integer> itr = adj[s].iterator();

               while (itr.hasNext())
               {
                   int v = itr.next();
                   if(!visited.get(v))
                       stack.push(v);
               }

           }
       }


}
