class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for(int[] temp:edges)
        {
            int node=temp[0];
            int neighbour=temp[1];
            adjList.get(node).add(temp[1]);
            adjList.get(neighbour).add(temp[0]);
        }

        return dfs(adjList,source,new HashSet<>(),destination);
    }

    boolean dfs(List<List<Integer>> adjList,int start,HashSet<Integer> visited,int destination)
    {
        if( start == destination) return true;

        List<Integer> neighbour=adjList.get(start);

        boolean flag=false;

        for(int i:neighbour)
        {
            if( !visited.contains(i) )
            {
                visited.add(i);
               if (dfs(adjList, i, visited, destination)) {

                    return true;
                }
                // visited.remove(i);
            }   
            
        }


        return false;
    }
}