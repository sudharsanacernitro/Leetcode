class Solution {

    boolean[][] visited;
    int n,m;
    public int numEnclaves(int[][] grid) {
        
         n=grid.length;
         m=grid[0].length;

        visited=new boolean[n][m];

        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                {
                    int notPossibleCount=bfs(i,j,grid,new boolean[n][m]);
                    count+=notPossibleCount;
                }
            }
        }
        return count;
    }

    int bfs(int x,int y,int[][] grid,boolean[][] reclist)
    {
        class Pair
        {   int x,y;
            Pair(int x,int y)
            {
                this.x=x;
                this.y=y;
            }
        }

       
        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(x,y));
        int count=0;

        boolean touchesBorder=false;

        while(!q.isEmpty())
        {
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                Pair curr=q.poll();
               
                int curr_x=curr.x;
                int curr_y=curr.y;

                if(reclist[curr_x][curr_y]) continue;

                if(curr_x == 0 || curr_x == n-1 || curr_y==0 || curr_y == m-1)
                    touchesBorder=true;

                 visited[curr_x][curr_y]=true;
                reclist[curr_x][curr_y]=true;


                if(curr_x+1 < n && !reclist[curr_x+1][curr_y] && grid[curr_x+1][curr_y] == 1)
                    q.add(new Pair(curr_x+1,curr_y));

                if(curr_x-1 >=0 && !reclist[curr_x-1][curr_y]  && grid[curr_x-1][curr_y] == 1)
                    q.add(new Pair(curr_x-1,curr_y));

                if(curr_y-1 >=0 && !reclist[curr_x][curr_y-1]  && grid[curr_x][curr_y-1] == 1)
                    q.add(new Pair(curr_x,curr_y-1));

                if(curr_y+1 < m && !reclist[curr_x][curr_y+1]  && grid[curr_x][curr_y+1] == 1)
                    q.add(new Pair(curr_x,curr_y+1));

                 count++;
            }
        }


        return touchesBorder?0:count;
    }
}