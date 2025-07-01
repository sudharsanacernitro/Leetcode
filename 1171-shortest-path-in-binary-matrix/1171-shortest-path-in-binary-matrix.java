class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        class Pair
        {
            int x,y,weight;
            Pair(int x,int y,int weight)
            {
                this.x=x;
                this.y=y;
                this.weight=weight;
            }
        }


        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        int direction[][]={{1,1},{-1,-1},{1,-1},{-1,1},{0,1},{1,0},{-1,0},{0,-1}};
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(0,0,0));

        int dist[][]=new int[n][m];
        for(int i[]:dist) Arrays.fill(i,Integer.MAX_VALUE);
        dist[0][0]=0;

        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            int x=curr.x,y=curr.y,w=curr.weight;

            for(int[] i:direction)
            {
                int nx=x+i[0],ny=y+i[1];

                if(nx >= 0 && nx < n && ny >=0 && ny < m && grid[nx][ny] == 0)
                {
                    if(dist[nx][ny] > dist[x][y]+1)
                    {
                        dist[nx][ny]= dist[x][y]+1;
                        pq.add(new Pair(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }

        return dist[n-1][m-1] == Integer.MAX_VALUE?-1:dist[n-1][m-1]+1;
    }
}