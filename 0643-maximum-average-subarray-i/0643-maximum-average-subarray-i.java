class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum=0;
        for(int i=0;i<k;i++)
        {
            maxSum+=nums[i];
        }
        
        int newSum=maxSum;
        for(int i=k;i<nums.length;i++)
        {
             newSum+=nums[i]-nums[i-k];
            
            maxSum=Math.max(newSum,maxSum);
        }
        
        return maxSum/(double)k;
    }
}