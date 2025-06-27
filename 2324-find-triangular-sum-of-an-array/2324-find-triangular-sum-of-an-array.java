class Solution {
    public int triangularSum(int[] dp) {
        
        int n=dp.length;

        int iteration=n-1;

        while(iteration > 0)
        {
            int arr[]=new int[iteration];

            for(int i=0;i< iteration;i++)
            {
                dp[i]=dp[i]+dp[i+1];
                dp[i]=dp[i]%10;
            }

            dp[iteration]=0;
            iteration--;
        }

        for(int i=0;i<n;i++)
        {
            if(dp[i]!=0) return(dp[i]);
        }

        return 0;
    }
}