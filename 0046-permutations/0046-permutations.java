class Solution {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        
        boolean visited[]=new boolean[nums.length];

        dfs(nums,visited,new ArrayList<>());

        return result;
    }

    void dfs(int[] nums,boolean[] visited,List<Integer> curr)
    {
        if(curr.size() == nums.length) 
        {
            result.add(new ArrayList<>(curr ) );
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                curr.add(nums[i]);

                dfs(nums,visited,curr);
                 visited[i]=false;
                curr.remove(curr.size()-1);
            }

           
        }
    }
}