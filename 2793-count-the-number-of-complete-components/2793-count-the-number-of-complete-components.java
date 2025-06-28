class Solution {

    boolean vis[];
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> adjList=new ArrayList<>();

        vis=new boolean[n];

        int completedComponent=0;

        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0;i<n;i++)
        {
            if(vis[i]) continue;

            int[] nodeCount=new int[1];
            int[] edgeCount=new int[1];

            dfs(adjList,nodeCount,edgeCount,i);

            int TheoraticalEdge = nodeCount[0]*(nodeCount[0]-1)/2;

            if(TheoraticalEdge == edgeCount[0]/2) completedComponent++;
        }
        System.out.println(adjList.toString());
        return completedComponent;
    }

    boolean dfs(List<List<Integer>> adjList, int[] nodeCount,int[] edgeCount,int curr)
    {

        vis[curr]=true;
        nodeCount[0]++;

        List<Integer> lst=adjList.get(curr);

        for(int i:lst)
        {
            edgeCount[0]++;
            if(!vis[i])
            {
                dfs(adjList,nodeCount,edgeCount,i);
            
            }
        }

        return false;

    }
}