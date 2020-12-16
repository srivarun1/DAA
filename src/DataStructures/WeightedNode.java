package DataStructures;

import java.util.Comparator;

public class WeightedNode implements Comparable<WeightedNode> {
    public int node;
    public int cost;

    public WeightedNode(int node , int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(WeightedNode other) {
        return other.cost==this.cost?0:other.cost > this.cost ?-1:1;
    }
}
