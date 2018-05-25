import java.util.*;



// This pis graph adjacency list example.
public class AdjacencyList{

public static void main(String[] args)
{
  System.out.println("Hello From Adjacency List");
  GraphNode g = new GraphNode(10);
  g.addEdges(0,1);
  g.addEdges(0,2);
  g.addEdges(0,7);
  g.addEdges(1,3);
  g.addEdges(1,5);
  g.addEdges(1,7);
  g.printlist();

}


}

class GraphNode{
  public int nVertices;
  public int nEdges;
  public LinkedList adjacencyList[];

  public GraphNode(int size)
  {
    nVertices = size;
    adjacencyList = new LinkedList[size];
    for(int i = 0; i< adjacencyList.length; i++)
    {
      adjacencyList[i] = new LinkedList();
    }
    System.out.println(adjacencyList.length);
  }

public void addEdges(int vertices, int edges)
{
  int length  = adjacencyList.length;
    if(adjacencyList == null || vertices > length)
    {
      System.out.println("Not Possible..");
      return;
    }

    adjacencyList[vertices].add(edges);
    System.out.println("Me called");
}

public void printlist()
{
  for(int i = 0;  i < adjacencyList.length ; i++)
  System.out.println(Arrays.asList(adjacencyList[i]));
}

}
