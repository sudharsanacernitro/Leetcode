class Solution {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
         Arrays.sort(candidates);

        dfs(candidates,target,0,new boolean[candidates.length],new ArrayList<>(),0);

        return result;
    }

    void dfs(int[] nums,int target,int start,boolean[] visited,List<Integer> curr,int currSum)
    {
        if(currSum  > target) return;

        if(currSum == target ){

            result.add(new ArrayList<>(curr) );
        }

        for(int i=start;i<nums.length;i++)
        {
             if (i > start && nums[i] == nums[i - 1]) continue;

             if(currSum+nums[i] > target) continue;
             
            if(!visited[i])
            {
                visited[i]=true;
                curr.add(nums[i]);

                dfs(nums,target,i+1,visited,curr,currSum+nums[i]);

                curr.remove(curr.size()-1);
                visited[i]=false;
            }
        }
    }
}