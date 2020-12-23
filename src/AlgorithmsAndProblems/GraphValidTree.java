package AlgorithmsAndProblems;

/*
 * LC - 261 : 100% speed , 96% space
 */
class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];

        for(int i = 0; i < n ; i++)
        {
            parent[i] = i;
        }
        parent[0] = 0;

        for(int  i = 0 ; i < edges.length; i++)
        {
            if(find(edges[i][0],parent) == find(edges[i][1],parent))
            {
                return false;
            }
            union(edges[i][0],edges[i][1],parent);
        }
        int val = find(0,parent);
        for(int i = 0 ;i < parent.length; i++)
        {
            if(find(i,parent) != val)
            {
                return false;
            }
        }
        return true;

    }

    public int find(int num,int[] parent)
    {
        if(parent[num] == num)
        {
            return num;
        }
        else
        {
            parent[num] =  find(parent[num],parent);
            return parent[num];
        }
    }

    public void union (int i, int j , int[] parent)
    {
        if(parent[j] == j && parent[i] == i || parent[j] == j && parent[i] != i)
            parent[j] = parent[i];
        if(parent[j] != j && parent[i] == i)
            parent[i] = parent[j];
    }


}
