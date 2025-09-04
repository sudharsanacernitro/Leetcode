class Solution {

    HashMap<String,Integer> dp = new HashMap<>();

    public int uniquePaths(int m, int n) {


       return dfs(m,n,new boolean[m][n],0,0);
        
    }

    public int dfs(int m,int n,boolean visited[][] , int x ,int y )
    {
        if( x >= m || y >= n || x < 0 || y < 0 || visited[x][y] ) return 0;

        if( x == m-1 && y == n-1)
        {
            return 1;
        }

        if( dp.containsKey(x+","+y)) return dp.get(x+","+y);

        visited[x][y] = true;
        
        int down = dfs( m , n , visited , x+1 , y);
        int left = dfs( m , n ,visited , x , y+1);

        dp.put(x+","+y,down+left);

        visited[x][y] = false;

        return down+left;
    }
}