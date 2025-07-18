class Solution {

    int n,m;

     class Pair
        {
            int x,y;
            Pair(int x,int y)
            {
                this.x=x;
                this.y=y;
            }
        }

    public int numIslands(char[][] grid) {
       

         n=grid.length;
         m=grid[0].length;

        int count=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == '1')
                {
                    bfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(int x,int y,char[][] grid)
    {
         Queue<Pair> q=new LinkedList<>();
         q.add(new Pair(x,y));

         while(!q.isEmpty())
         {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Pair curr=q.poll();

                if(curr.x >= n || curr.x < 0 || curr.y >= m || curr.y < 0) continue;

                if(grid[curr.x][curr.y] != '1') continue;
                grid[curr.x][curr.y]='0';

                q.add(new Pair(curr.x+1 ,curr.y));
                q.add(new Pair(curr.x-1,curr.y));
                q.add(new Pair(curr.x,curr.y+1));
                q.add(new Pair(curr.x,curr.y-1));


            }
         }

    }
}