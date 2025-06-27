class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;

        int dp[][]=new int[n][m];

        for(int i=0;i<m;i++)
        {
            dp[0][i] = matrix[0][i];
        }

        for(int i=1;i<n;i++)
        {
            int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
            int index=0;

            for(int j=0;j<m;j++)
            {
                int val = dp[i - 1][j];
                if (val < min1) {
                    min2 = min1;
                    min1 = val;
                    index = j;
                } else if (val < min2) {
                    min2 = val;
                }
            }

           for(int j=0;j<m;j++)
           {
                if(j != index)
                dp[i][j]=matrix[i][j]+min1;

                else
                dp[i][j]=matrix[i][j]+min2;
           }
        }

        int min=dp[n-1][0];

        for(int j=1;j<m;j++)
        min=Math.min(dp[n-1][j],min);
        

        return min;
    }

}