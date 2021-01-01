package AlgorithmsAndProblems;
import java.util.*;

/**
 * https://binarysearch.com/problems/Level-Order-Alternating
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class LevelOrderAlt {
    public int[] solve(Tree root) {
        int mainSum = Integer.MAX_VALUE;
        int level = -1;
        ArrayList<Integer> alt = new ArrayList();
        Queue<Tree> q = new LinkedList();

        q.add(root);
        while(!q.isEmpty())
        {
            level++;
            int size= q.size();
            ArrayList<Integer> levelList = new ArrayList();
            for(int i = 0; i < size; i++)
            {
                Tree node = q.poll();
                ;                levelList.add(node.val);
                if(node.left!= null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }

            }
            if(level%2 == 0)
            {
                for(int i = 0 ; i < levelList.size(); i++)
                {
                    alt.add(levelList.get(i));
                }
            }
            else
            {
                for(int i = levelList.size()-1 ; i >= 0 ; i--)
                {
                    alt.add(levelList.get(i));
                }
            }

        }

        int[] ret = new int[alt.size()];

        for(int i = 0 ; i < ret.length; i++)
        {
            ret[i] = alt.get(i);
        }

        return ret;
    }
}