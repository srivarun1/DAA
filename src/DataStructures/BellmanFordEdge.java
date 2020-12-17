package DataStructures;

public class BellmanFordEdge {
    int source;
    int destination;
    int weight;

    public BellmanFordEdge(int source, int destination,int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
