package AlgorithmsAndProblems;

//LC323

public class numOfConnectedComponents {

        int nc;
        public int countComponents(int n, int[][] edges) {
            int[] parent = new int[n];
            if(n == 0)
            {
                return 0;
            }
            nc = n;
            for(int i = 0; i < n ; i++)
            {
                parent[i] = i;
            }
            parent[0] = 0;

            for(int  i = 0 ; i < edges.length; i++)
            {
                if(find(edges[i][0],parent) == find(edges[i][1],parent))
                {
                    continue;
                }
                union(edges[i][0],edges[i][1],parent);
            }

            return nc;

        }

        public int find(int num,int[] parent)
        {
            if(parent[num] == num)
            {
                return num;
            }
            else
            {
                parent[num] = find(parent[num],parent);
                return parent[num];
            }
        }

        public void union (int i, int j , int[] parent)
        {
            if(parent[j] != j && parent[i] != i)
            {
                int num1 = find(parent[i],parent);
                int num2 = find(parent[j],parent);
                if(num1 != num2)
                {
                    parent[num2] = num1;
                }
            }
            else if(parent[j] == j && parent[i] == i || parent[j] == j && parent[i] != i)
            {
                parent[j] = parent[i];
            }
            else if(parent[j] != j && parent[i] == i)
            {
                parent[i] = parent[j];
            }
            nc--;
        }

}
