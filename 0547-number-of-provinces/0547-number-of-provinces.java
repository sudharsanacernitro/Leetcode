class Solution {

    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {

        int n=isConnected.length,province=0;

        visited=new boolean[n];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            List<Integer> lst=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                if( i == j || isConnected[i][j] == 0)
                {
                    continue;
                } 
                
                lst.add(j);
            }
            adjList.add(lst);
        }

        System.out.println(adjList.toString());

        for(int i=0;i<n;i++)
        {
            if(visited[i]) continue;

            visited[i]=true;
            dfs(adjList,i,new HashSet<>());
            province++;
        }

        return province;
    }

    void dfs( List<List<Integer>> adjList,int curr,HashSet<Integer> vis)
    {
        visited[curr]=true;
       

        List<Integer> lst=adjList.get(curr);
        for(int i:lst)
        {
            if(!vis.contains(i))
            {
                 vis.add(curr);
                 dfs(adjList,i,vis);
                 vis.remove(vis.size()-1);
            }
            
        }
    }
}