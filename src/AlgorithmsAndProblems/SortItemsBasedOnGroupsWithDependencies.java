package AlgorithmsAndProblems;
import java.util.*;

public class SortItemsBasedOnGroupsWithDependencies {

        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            HashMap<Integer,List<Integer>> groupMap = new HashMap();
            HashMap<Integer,List<Integer>> itemMap = new HashMap();
            HashSet<Integer> visited = new HashSet();
            for(int i = 0 ; i < group.length; i++)
            {
                if(!groupMap.containsKey(group[i]))
                {
                    groupMap.put(group[i],new ArrayList<Integer>());
                }
                groupMap.get(group[i]).add(i);
            }

            for(int i = 0 ; i < beforeItems.size() ; i++)
            {
                List<Integer> parentsOfVertice = beforeItems.get(i);

                for(int j = 0 ; j < parentsOfVertice.size() ; j++)
                {
                    if(!itemMap.containsKey(parentsOfVertice.get(j)))
                    {
                        itemMap.put(parentsOfVertice.get(j),new ArrayList<Integer>());
                    }
                    itemMap.get(parentsOfVertice.get(j)).add(i);
                }
            }

            boolean[] anc = new boolean[n];
            Stack<Integer> stack = new Stack();
            for(int i = 0 ; i < n; i++)
            {
                if(visited.contains(i))
                {
                    continue;
                }

                if(!topSort(visited,stack,groupMap,itemMap,anc,i,group))
                {
                    return new int[0];
                }
            }
            int[] arr = new int[n];
            int itr = 0;
            while(!stack.isEmpty() && itr < n)
            {
                arr[itr++] = stack.pop();
            }
            return arr;
        }

        public boolean topSort(HashSet<Integer> visited,Stack<Integer> stack,HashMap<Integer,List<Integer>> groupMap,HashMap<Integer,List<Integer>> itemMap,boolean[] anc,int vertice,int[] group)
        {
            if(anc[vertice])
            {
                System.out.println("ancestor vertice : " + vertice);
                return false;
            }

            if(visited.contains(vertice))
            {
                return true;
            }
            anc[vertice] = true;
            visited.add(vertice);

            List<Integer> parents = groupMap.get(group[vertice]);
            HashMap<Integer,List<Integer>> map = new HashMap();

            for(int i =0 ; i< parents.size() ; i++)
            {
                List<Integer> children = itemMap.getOrDefault(parents.get(i),new ArrayList<Integer>());
                for(int j = 0; j< children.size(); j++)
                {
                    if(group[children.get(j)] == group[parents.get(i)])
                    {
                        if(isCycle(children.get(j),parents.get(i),map))
                        {
                            return false;
                        }
                        if(!map.containsKey(parents.get(i)))
                        {
                            map.put(parents.get(i),new ArrayList<Integer>());
                        }
                        map.get(parents.get(i)).add(children.get(j));

                        continue;
                    }


                    if(!topSort(visited,stack,groupMap,itemMap,anc,children.get(j),group))
                    {
                        return false;
                    }
                }
                if(children.size() == 0)
                {
                    visited.add(parents.get(i));
                }
            }

            anc[vertice] = false;
            HashSet<Integer> pushed = new HashSet();
            for(int i =0 ; i< parents.size() ; i++)
            {
                if(!pushed.contains(parents.get(i)))
                {
                    pushIntoStack(pushed,parents.get(i),stack,map);
                    visited.add(parents.get(i));
                }
            }
            //  System.out.println(stack);

            return true;

        }
        public boolean isCycle(int key,int value, HashMap<Integer,List<Integer>> map)
        {
            List<Integer> lst = map.get(key);
            if(lst == null)
            {
                return false;
            }
            for(int i = 0 ; i < lst.size(); i++)
            {
                if(lst.get(i) == value || isCycle(lst.get(i),value,map))
                {
                    return true;
                }
            }
            return false;
        }
        public void pushIntoStack(HashSet<Integer> p, int val, Stack<Integer> stack, HashMap<Integer,List<Integer>> map)
        {
            if(map.containsKey(val))
            {
                for(int i = 0 ; i < map.get(val).size(); i++)
                {
                    pushIntoStack(p,map.get(val).get(i),stack,map);
                }
            }
            if(!p.contains(val))
            {
                stack.push(val);
                p.add(val);
            }


        }

}
