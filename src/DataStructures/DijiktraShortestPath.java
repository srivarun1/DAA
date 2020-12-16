package DataStructures;
import java.util.*;
public class DijiktraShortestPath {
    int vertices;
    int[] travelCost;
    List<List<WeightedNode>> adj;
    HashSet<Integer> visited = new HashSet();
    PriorityQueue<WeightedNode> getCheapestNeighbour = new PriorityQueue<>();


    public DijiktraShortestPath(int vertices)
    {
        this.vertices = vertices;
        travelCost = new int[vertices];
    }

    public void getShortestPath(List<List<WeightedNode>> adj,int vertice)
    {
        for(int i = 0; i < vertices; i++)
        {
            travelCost[i] = Integer.MAX_VALUE;
        }
        travelCost[vertice] = 0;
        getCheapestNeighbour.add(new WeightedNode(vertice,0));

        while(visited.size() < vertices) {
            WeightedNode node = getCheapestNeighbour.poll();
            visited.add(node.node);
            checkNeighbours(adj,node);
        }
    }

    public void checkNeighbours(List<List<WeightedNode>> adj,WeightedNode node)
    {
        int newDistance = -1;
        if(node != null) {
            for (int i = 0; i < adj.get(node.node).size(); i++) {
                WeightedNode adjacentNode = adj.get(node.node).get(i);

                if (!visited.contains(adjacentNode.node)) {
                    newDistance = travelCost[node.node] + adjacentNode.cost;

                    if (newDistance < travelCost[adjacentNode.node]) {
                        travelCost[adjacentNode.node] = newDistance;
                    }
                    WeightedNode weightedNode = new WeightedNode(adjacentNode.node, travelCost[adjacentNode.node]);
                    getCheapestNeighbour.add(weightedNode);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges
        List<List<WeightedNode> > adj = new ArrayList<List<WeightedNode> >();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<WeightedNode> item = new ArrayList<WeightedNode>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new WeightedNode(1, 9));
        adj.get(0).add(new WeightedNode(2, 6));
        adj.get(0).add(new WeightedNode(3, 5));
        adj.get(0).add(new WeightedNode(4, 3));

        adj.get(2).add(new WeightedNode(1, 2));
        adj.get(2).add(new WeightedNode(3, 4));

        // Calculate the single source shortest path
        DijiktraShortestPath dpq = new DijiktraShortestPath(V);
        dpq.getShortestPath(adj, source);

        // Print the shortest path to all the nodes
        // from the source node
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpq.travelCost.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.travelCost[i]);
    }


}
