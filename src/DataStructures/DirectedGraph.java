package DataStructures;
import java.util.*;

public class DirectedGraph {

    private int vertices;
    private LinkedList<Integer> adj[];


    public DirectedGraph(int vertices)
    {
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++)
        {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int startNode, int destinationNode)
    {
        adj[startNode].add(destinationNode);
    }

    public void breadthFirstTraversal(int source)
    {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> level = new LinkedList();

        visited[source] = true;
        level.add(source);


        while(!level.isEmpty())
        {
            int node = level.poll();
            System.out.print(" " + node + " ");
            Iterator<Integer> i = adj[node].iterator();
            while(i.hasNext())
            {
                int val = i.next();
                if(!visited[val])
                {
                    visited[val] = true;
                    level.add(val);
                }
            }

        }

    }

    public void depthFirstTraversal(int source)
    {
        boolean[] visited = new boolean[vertices];
        depthFirstTraversal(visited,source);

    }
    public void depthFirstTraversal(boolean[] visited, int node)
    {

        Iterator<Integer> i = adj[node].iterator();
        visited[node] = true;
        System.out.print(" " + node + " ");
        while(i.hasNext())
        {
            int val = i.next();
            if(!visited[val]) {
                depthFirstTraversal( visited, val);
            }
        }
    }

    public boolean isCycle()
    {
        boolean[] visited = new boolean[vertices];
        boolean[] ancestor = new boolean[vertices];

        for(int i = 0; i < vertices; i++)
        {
            if(isCycleForStartPoint(visited,ancestor,i))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isCycleForStartPoint(boolean[] visited, boolean[] ancestor, int vertice)
    {
        if(ancestor[vertice])
        {
            return true;
        }

        if(visited[vertice])
        {
            return false;
        }

        ancestor[vertice] = true;
        visited[vertice] = true;

        Iterator<Integer> i = adj[vertice].iterator();
        while(i.hasNext())
        {
            if(isCycleForStartPoint(visited,ancestor,i.next())) {
                return true;
            }
        }
        ancestor[vertice] = false;

        return false;
    }

    public static void main(String[] args)
    {
        DirectedGraph g = new DirectedGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.breadthFirstTraversal(2);
        System.out.println();
        g.depthFirstTraversal(2);
        System.out.println();
        if(g.isCycle())
        {
            System.out.println("Given graph is cyclic");
        }
    }
}
