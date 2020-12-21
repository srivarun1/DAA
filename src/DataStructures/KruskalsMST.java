package DataStructures;
import java.util.*;
public class KruskalsMST {
    BellmanFordEdge[] edge;
    int vertices;
    int edges;

    public KruskalsMST(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        edge = new BellmanFordEdge[edges];
        for(int i = 0 ; i < edges; i++)
        {
            edge[i] = new BellmanFordEdge();
        }
    }

    public void findMST()
    {
        BellmanFordEdge[] result = new BellmanFordEdge[edges];
        DisjointSets set = new DisjointSets(vertices);

        int e = 0;

        for(int i = 0 ; i < edges; i++)
        {
            result[i] = new BellmanFordEdge();
        }

        Arrays.sort(edge);
        int i = 0;
        while(e<vertices-1)
        {
            BellmanFordEdge currEdge = edge[i++];
            if(set.findParent(currEdge.source) != set.findParent(currEdge.destination))
            {
                result[e++] = currEdge;
                set.union(currEdge.source,currEdge.destination);
            }


        }

        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(result[i].source + " -- " + result[i].destination + " = " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("MCT " + minimumCost);
    }


    public static void main(String[] args)
    {


        //Driver code taken from GEEKSFORGEEKS

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        KruskalsMST graph = new KruskalsMST(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].source = 0;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].source = 2;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.findMST();
    }
}
