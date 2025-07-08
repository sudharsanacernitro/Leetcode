class Solution {

    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {

        List<List<Integer>> adj=new ArrayList<>();

        int V=isConnected.length;

        visited=new boolean[V];

        for(int i=0;i<V;i++)
        {
            List<Integer> lst=new ArrayList<>();
            for(int j=0;j<V;j++)
            {
                if( i == j || isConnected[i][j] == 0) continue;

                lst.add(j);
            }

            adj.add(lst);
        }

        System.out.println(adj.toString());
        
        int count=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i] ) continue;

            count++;
            dfs(adj,visited,i);
        }

        return count;
    }

    void dfs(List<List<Integer>> adj,boolean[] visited,int curr)
    {
        if(visited[curr]) return;

        visited[curr]=true;

        for(int i:adj.get(curr))
        {
            if(!visited[i])
            dfs(adj,visited,i);
        }
    }
}