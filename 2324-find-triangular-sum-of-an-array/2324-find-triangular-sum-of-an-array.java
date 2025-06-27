class Solution {
    public int triangularSum(int[] dp) {
        
        int iteration=dp.length-1;

        // int iteration=n-1;

        while(iteration > 0)
        {
            // int arr[]=new int[iteration];

            for(int i=0;i< iteration;i++)
            {
                dp[i]=(dp[i]+dp[i+1])%10;
                // dp[i]=dp[i]%10;
            }

            // dp[iteration]=0;
            iteration--;
        }

       
        return dp[0];
    }
}