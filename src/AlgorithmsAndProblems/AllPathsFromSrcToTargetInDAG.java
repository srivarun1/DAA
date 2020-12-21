package AlgorithmsAndProblems;
import java.util.*;

public class AllPathsFromSrcToTargetInDAG {

        List<List<Integer>> paths;
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            paths = new ArrayList();
            ArrayList<Integer> visited = new ArrayList();
            visited.add(0);
            findPath(graph,visited,0);
            return paths;
        }

        public void findPath(int[][] graph, ArrayList<Integer> visited, int currentNode)
        {

            if(currentNode == graph.length-1)
            {
                List<Integer> path = new ArrayList<>(visited);
                paths.add(path);
            }

            for(int i = 0 ; i < graph[currentNode].length; i++)
            {
                if(!visited.contains(graph[currentNode][i]))
                {
                    visited.add(graph[currentNode][i]);
                    findPath(graph,visited,graph[currentNode][i]);
                    visited.remove(visited.size()-1);
                }
            }
            return;
        }

        public static void main(String[] args)
        {

            int graph[][] = new int[][] { { 1,2,0, 0 },
                    { 3,0,0,0 },
                    { 3,0,0,0 },
                    { 0, 0, 0, 0} };
            AllPathsFromSrcToTargetInDAG test = new AllPathsFromSrcToTargetInDAG();
            System.out.println(test.allPathsSourceTarget(graph).toString());
        }
}
