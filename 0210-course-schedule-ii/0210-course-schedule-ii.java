class Solution {

    int result[];
    int index=0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        result=new int[numCourses];

        boolean[] visited=new boolean[numCourses];

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());


        for(int[] i:prerequisites) adj.get(i[0]).add(i[1]);

        for(int i=0;i<numCourses;i++)
        {
            if(!visited[i])
            if(!dfs(adj,i,visited,new boolean[numCourses]))
            return new int[0];
        }

        return result;
    
    }

    boolean dfs(List<List<Integer>> adj,int curr,boolean[] visited,boolean[] recStack)
    {
        visited[curr]=true;
        recStack[curr]=true;
        for(int i:adj.get(curr))
        {
            if(!visited[i] )
            {
                 if(!dfs(adj,i,visited,recStack)) return false;
            }
            else if(recStack[i])
            {
                return false;
            }
        }

        recStack[curr]=false;
        result[index++]=curr;
        return true;
    }
}