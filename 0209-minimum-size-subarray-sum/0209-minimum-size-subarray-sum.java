class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n=nums.length;
        int minLength=Integer.MAX_VALUE;

        int sum=0,left=0;

        for(int i=0;i<n;i++)
        {
             sum+=nums[i];

             while(sum >= target )
             {
                minLength=Math.min(minLength,i-left+1);
                sum-=nums[left++];


             }

        }

        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}