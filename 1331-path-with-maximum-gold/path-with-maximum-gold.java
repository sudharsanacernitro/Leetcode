class Solution {
    int maxGold=0;
    public int getMaximumGold(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dfs(i,j,grid,n,m,new boolean[n][m],0);
            }
        }
        return maxGold;
    }

    void dfs(int x,int y,int[][] maze,int n,int m,boolean visited[][],int currSum)
    {
        if( x< 0 || y<0 || x >= n || y >= m || visited[x][y] || maze[x][y] == 0)
        return;

        currSum+=maze[x][y];
        visited[x][y]=true;
        maxGold=Math.max(currSum,maxGold);

        dfs(x+1,y,maze,n,m,visited,currSum);
        dfs(x,y+1,maze,n,m,visited,currSum);
        dfs(x-1,y,maze,n,m,visited,currSum);
        dfs(x,y-1,maze,n,m,visited,currSum);

        visited[x][y]=false;


    }
}