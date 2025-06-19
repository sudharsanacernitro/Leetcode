class Solution {
    public void rotate(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++)
        {
        for(int j=i+1;j<m;j++)
        {
            int temp1=matrix[i][j];
            matrix[i][j]= matrix[j][i];
            matrix[j][i]=temp1;

        }
            for(int j=0;j<(n/2);j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
}