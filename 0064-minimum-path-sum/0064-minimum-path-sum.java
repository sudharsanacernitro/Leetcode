class Solution {
    public int minPathSum(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;

        int [][] dp=new int[n][m];

        int prevSum=0;

        for(int i=0;i<n;i++)
        {
            prevSum+=grid[i][0];

            dp[i][0] = prevSum;
        } 
        prevSum=0;

        for(int j=0;j<m;j++)
        {
            prevSum+=grid[0][j];
            dp[0][j]=prevSum;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                int minPath=Math.min(dp[i-1][j] , dp[i][j-1]);

                dp[i][j]=minPath+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}