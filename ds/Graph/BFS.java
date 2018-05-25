/**
- This is Breath-First Search Example of graph Traversal
- It will use level-order traversal
- The Iterative approach of BFS is similer as DFS but the only difference is we will use quese rather than stack.
-
*/

// Setup Adjacency List graph and main method for testing BFS
import java.util.*;
public class BFS{


}

class Graph_BFS
{
  int vertices;
  int edges;
  LinkedList<Integer> adj[];

//This constructor will initialize the size of graph.
  public Graph_BFS(int size)
  {
    this.vertices = size;
    adj = new LinkedList[size];
    //Lets initialize elements of the LinkedList
    for(int i = 0; i < adj.length ; i++)
            adj[i] = new LinkedList();
  }

  public void addEdges(int v, int e){

    if(v > vertices) return;
    adj[v].add(e);
  }

  // This is the iterative approach of the BFS search algorithm
  // prints BFS traversal from a given source s
      void BFS(int s)
      {
          // Mark all the vertices as not visited(By default
          // set as false)
          boolean visited[] = new boolean[vertices];

          // Create a queue for BFS
          LinkedList<Integer> queue = new LinkedList<Integer>();

          // Mark the current node as visited and enqueue it
          visited[s]=true;
          queue.add(s);

          while (queue.size() != 0)
          {
              // Dequeue a vertex from queue and print it
              s = queue.poll();
              System.out.print(s+" ");

              // Get all adjacent vertices of the dequeued vertex s
              // If a adjacent has not been visited, then mark it
              // visited and enqueue it
              Iterator<Integer> i = adj[s].listIterator();
              while (i.hasNext())
              {
                  int n = i.next();
                  if (!visited[n])
                  {
                      visited[n] = true;
                      queue.add(n);
                  }
              }
          }

}


}
