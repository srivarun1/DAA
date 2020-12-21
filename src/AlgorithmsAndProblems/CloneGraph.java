package AlgorithmsAndProblems;
import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }

        HashMap<Integer,Node> map = new HashMap();

        Node clone = cloneGraph(node,map);

        return clone;
    }

    public Node cloneGraph(Node node, HashMap<Integer,Node> map)
    {

        Node clone = new Node(node.val);
        map.put(clone.val,clone);
        for(int i = 0; i < node.neighbors.size(); i++)
        {
            if(map.containsKey(node.neighbors.get(i).val))
            {
                clone.neighbors.add(map.get(node.neighbors.get(i).val));
                continue;
            }
            else
            {
                Node cloneChild = cloneGraph(node.neighbors.get(i),map);
                clone.neighbors.add(cloneChild);
            }

        }
        return clone;

    }
}