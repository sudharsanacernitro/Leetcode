class Solution {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int start=0;
        int destination=graph.length-1;

        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<graph.length;i++)
        {
            int[] arr=graph[i];

            List<Integer> lst=new ArrayList<>();
            for(int j=0;j<arr.length;j++)
            {
                lst.add(arr[j]);
            }
            adjList.add(lst);
        }

        dfs(adjList,0,destination,new ArrayList<>());

                System.out.println(result.toString());

        return result;
    }

    void dfs(List<List<Integer>> adjList ,int start ,int target ,List<Integer> curr )
    {

         curr.add(start);
        if(target == start)
        {
            result.add(new ArrayList<>(curr) );
        }
        else{
                List<Integer> neighbours=adjList.get(start);

                for(int i : neighbours)
                {
                    dfs(adjList,i,target,curr);
                }
        }

     curr.remove(curr.size()-1);

    }
}