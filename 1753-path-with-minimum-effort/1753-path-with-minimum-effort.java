class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        if(heights[0].length==1 && heights.length==1 ) return 0;
        class Pair
        { int x,y,weight;
            Pair(int x,int y,int weight)
            {
                this.x=x;
                this.y=y;
                this.weight=weight;
            }
        }
        int n=heights.length;
        int m=heights[0].length;

        int[][] dist=new int[n][m];

        for(int i[]:dist) Arrays.fill(i,Integer.MAX_VALUE);

        dist[0][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);

      pq.add(new Pair(0,0,0));



        int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};

        
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();

            // if(curr.x < 0 || curr.y < 0 || curr.x >=n || curr.y >= m ) continue;

            for(int i[] : direction)
            {
               int nx=curr.x+i[0];
               int ny=curr.y+i[1];

               if(nx >=0 && nx < n && ny >=0 && ny <m)
               {
                    int next=Math.max(curr.weight,Math.abs(heights[nx][ny]-heights[curr.x][curr.y]) );

                    if(next < dist[nx][ny])
                    {
                        dist[nx][ny]=next;
                        pq.add(new Pair(nx,ny,dist[nx][ny]) );
                    }
               }
            }


        }
        if(dist[n-1][m-1]==Integer.MAX_VALUE) return -1;

        return dist[n-1][m-1];
    }
}