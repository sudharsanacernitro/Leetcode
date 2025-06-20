class Solution {


    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;

        if(n==1) return 1;
       int[] dp=new int[n];

       Arrays.fill(dp,1);

        int length=0;

       for(int i=1;i<n;i++)
       {

        int prevMax=0;

        for(int j=0;j<i;j++)
        {
            if(nums[j] < nums[i])
            {
                prevMax=Math.max(dp[j],prevMax);
            }
        }
        dp[i]=prevMax+dp[i];
        length=Math.max(dp[i],length);
       }


       return length;
    }



    
}