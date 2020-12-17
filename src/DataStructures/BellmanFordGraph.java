package DataStructures;

public class BellmanFordGraph {
    int vertices;
    int edges;
    BellmanFordEdge[] edgeDetails;
    int distForVertice[];

    public BellmanFordGraph(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        edgeDetails= new BellmanFordEdge[edges];
        for(int i = 0 ; i < edges; i++)
        {
            edgeDetails[i] = new BellmanFordEdge(0,0,0);
        }
        distForVertice = new int[vertices];
    }

    public boolean computeBellmanFordMinimumPath(int startNode)
    {
        for(int i = 0 ; i < vertices; i++)
            distForVertice[i] = Integer.MAX_VALUE;

        distForVertice[startNode] = 0;

        for(int i=0; i < vertices-1;i++)
        {
            for(int j = 0; j < edges; j++)
            {
                BellmanFordEdge edge = edgeDetails[j];
                if(distForVertice[edge.source] != Integer.MAX_VALUE && distForVertice[edge.source]+edge.weight < distForVertice[edge.destination])
                {
                    distForVertice[edge.destination] = distForVertice[edge.source]+edge.weight;
                }
            }
        }

        for(int i = 0 ; i < edges; i++)
        {
            BellmanFordEdge edge = edgeDetails[i];
            if(distForVertice[edge.source] != Integer.MAX_VALUE && distForVertice[edge.source]+edge.weight < distForVertice[edge.destination])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int vertices = 5; // Number of vertices in graph
        int edges = 8; // Number of edges in graph

        BellmanFordGraph graph = new BellmanFordGraph(vertices, edges);

        graph.edgeDetails[0].source = 0;
        graph.edgeDetails[0].destination = 1;
        graph.edgeDetails[0].weight = -1;

        graph.edgeDetails[1].source = 0;
        graph.edgeDetails[1].destination = 2;
        graph.edgeDetails[1].weight = 4;

        graph.edgeDetails[2].source = 1;
        graph.edgeDetails[2].destination = 2;
        graph.edgeDetails[2].weight = 3;

        graph.edgeDetails[3].source= 1;
        graph.edgeDetails[3].destination = 3;
        graph.edgeDetails[3].weight = -4; //Negative cycle input

        graph.edgeDetails[4].source = 1;
        graph.edgeDetails[4].destination = 4;
        graph.edgeDetails[4].weight = 2;

        graph.edgeDetails[5].source = 3;
        graph.edgeDetails[5].destination = 2;
        graph.edgeDetails[5].weight = 5;

        graph.edgeDetails[6].source = 3;
        graph.edgeDetails[6].destination = 1;
        graph.edgeDetails[6].weight = 1;

        graph.edgeDetails[7].source = 4;
        graph.edgeDetails[7].destination = 3;
        graph.edgeDetails[7].weight = -3;

        if(graph.computeBellmanFordMinimumPath(0))
        {
            for(int i = 0; i < graph.distForVertice.length;i++)
                System.out.print(" " + graph.distForVertice[i]);
        }
        else
        {
            System.out.println("Negative cycle detected");
        }
    }
}

