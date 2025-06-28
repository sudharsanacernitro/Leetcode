class Solution {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] adjList) {
        
        int start=0;
        int destination=adjList.length-1;


        dfs(adjList,0,destination,new ArrayList<>());

                System.out.println(result.toString());

        return result;
    }

    void dfs(int[][] adjList ,int start ,int target ,List<Integer> curr )
    {

         curr.add(start);
        if(target == start)
        {
            result.add(new ArrayList<>(curr) );
        }
        else{
               int[] neighbours=adjList[start];

                for(int i : neighbours)
                {
                    dfs(adjList,i,target,curr);
                }
        }

     curr.remove(curr.size()-1);

    }
}