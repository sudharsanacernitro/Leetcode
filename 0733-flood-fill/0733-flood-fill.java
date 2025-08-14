class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        class Pair
        {
            int r,c;
            Pair(int r,int c)
            {
                this.r = r;
                this.c = c;
            }
        }

        Queue<Pair> q = new LinkedList<>();

        q.add( new Pair(sr,sc));

        int n = image.length;
        int m = image[0].length;

        int currColor = image[sr][sc];

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0 ;i< size ; i++)
            {
                Pair curr = q.poll();

                int currC = curr.c;
                int currR = curr.r;

                if( image[currR][currC] == color || image[currR][currC] != currColor ) continue;

                image[currR][currC] = color;

                if(currC+1 < m) q.add( new Pair(currR , currC+1));
                if(currC-1 >= 0) q.add(new Pair(currR , currC-1));

               if(currR+1 < n) q.add( new Pair(currR+1 , currC));
                if(currR-1 >= 0) q.add(new Pair(currR-1 , currC));
            }
        }

        return image;


    }
}