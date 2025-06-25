class Solution {

    int squares=0;
    int n,m;
    int possibleWays=0;

    public int uniquePathsIII(int[][] grid) {
        
        n=grid.length;
        m=grid[0].length;

        int startx=0,starty=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) 
            {
            if(grid[i][j] != -1) squares++;
             if (grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                }
            }
        }

        dfs(grid,startx,starty,new boolean[n][m] , 1);

        return possibleWays;
    }

    void dfs(int[][] grid,int i,int j,boolean visited[][],int currVisitedSquares)
    {
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == -1) return;

        if( grid[i][j] == 2)
        {
            if(currVisitedSquares == squares)
            possibleWays++;
            return;
        }

        visited[i][j]=true;

        dfs(grid,i+1,j,visited,currVisitedSquares+1);
        dfs(grid,i,j+1,visited,currVisitedSquares+1);
        dfs(grid,i-1,j,visited,currVisitedSquares+1);
        dfs(grid,i,j-1,visited,currVisitedSquares+1);

        visited[i][j]=false;



    }
}