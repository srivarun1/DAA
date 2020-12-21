package DataStructures;

public class BellmanFordEdge implements Comparable<BellmanFordEdge> {
    int source;
    int destination;
    int weight;


    public BellmanFordEdge()
    {}
    public BellmanFordEdge(int source, int destination,int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(BellmanFordEdge other) {
         if(other.weight > this.weight) {
             return -1;
         }
         else if(other.weight < this.weight)
         {
             return 1;
         }
         else
         {
             return 0;
         }
    }
}
