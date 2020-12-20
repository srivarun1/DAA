package DataStructures;
import java.util.*;

public class PrimsMST {

    boolean[] visited;
    int[] cost;
    int vertices;
    int[][] adjMatrix;
    int[] parent;

    public PrimsMST(int vertices,int[][] adjMatrix)
    {
        this.vertices = vertices;
        this.adjMatrix = adjMatrix;
        cost = new int[vertices];
        visited = new boolean[vertices];
        parent = new int[vertices];
    }

    public int getMinNode()
    {
        int min = Integer.MAX_VALUE;
        int node = -1;
        for(int i = 0; i < vertices ; i++)
        {
            if(!visited[i])
            {
                if(cost[i] < min)
                {
                    min = cost[i];
                    node = i;
                }
            }
        }
        return node;
    }
    public void primsMst()
    {
        for(int i = 0 ; i < vertices; i++)
        {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[0] = 0;
        parent[0] = -1;


        for(int j = 0 ; j < vertices-1; j++)
        {
            int id = getMinNode();
            int val = cost[id];

            if(!visited[id])
            {
                visited[id] = true;
                for(int i = 0 ; i < vertices;i++)
                {
                    if(visited[i] == false && adjMatrix[id][i] < cost[i] && adjMatrix[id][i] != 0)
                    {
                        cost[i] = adjMatrix[id][i];
                        parent[i] = id;
                    }
                }
            }
        }

        print();


    }
    public void print()
    {
        for(int i = 0 ; i < vertices; i++)
        {
            System.out.println(parent[i] + " ---------> " + i);
        }
    }

    public static void main(String[] args)
    {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 4, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        PrimsMST p = new PrimsMST(5,graph);

        p.primsMst();

    }

}
