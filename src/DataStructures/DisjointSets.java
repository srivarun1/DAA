package DataStructures;

public class DisjointSets {
    int[] parent;
    int[] rank;
    int size;

    public DisjointSets(int size)
    {
        parent = new int[size];
        rank = new int[size];
        this.size = size;
        initParentForValues();
    }

    public void initParentForValues()
    {
        for(int i = 0  ; i < size; i++)
        {
            parent[i] = i;
        }
    }

    public int findParent(int setValue)
    {
        if(parent[setValue] == setValue)
        {
            return setValue;
        }
        else
        {
            int parentId = findParent(parent[setValue]);
            parent[setValue] = parentId;
        }
        return parent[setValue];
    }

    public void union(int x, int y)
    {
        int xroot = findParent(x);
        int yroot = findParent(y);

        if(xroot == yroot)
        {
            return;
        }

        if(rank[xroot] > rank[yroot])
        {
            parent[xroot] = yroot;
        }
        else if(rank[yroot] > rank[xroot])
        {
            parent[yroot] = xroot;
        }
        else
        {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    public static void main(String[] args)
    {
        int n = 5;
        DisjointSets dus =
                new DisjointSets(n);

        dus.union(0, 2);

        dus.union(4, 2);

        dus.union(3, 1);

        if (dus.findParent(4) == dus.findParent(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (dus.findParent(1) == dus.findParent(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }



}
