class Solution {
    public int maximalSquare(char[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;

        int[][] dp=new int[n][m];
        int max=0;

        for(int i=0;i<n;i++)
        {
            dp[i][0]=Integer.parseInt(matrix[i][0]+"");
             max=Math.max(max,dp[i][0]);
        }
        for(int i=0;i<m;i++) 
        {
            dp[0][i]=Integer.parseInt(matrix[0][i]+"");
             max=Math.max(max,dp[0][i]);
        }

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(matrix[i][j] == '0') continue;
                int min = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));

                if(min!=0) dp[i][j]=min+1;
                else dp[i][j]=Integer.parseInt(matrix[i][j]+"");

                max=Math.max(max,dp[i][j]);
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return max*max;
    }
}