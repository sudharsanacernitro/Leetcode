class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        class Pair
        {
            int node,weight;
            Pair(int node,int weight)
            {
                this.node=node;
                this.weight=weight;
            }
        }

        List<List<Pair>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int weight = time[2];

            adj.get(source).add(new Pair(destination,weight));
        }


        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        dist[0]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.weight-b.weight);
        HashSet<Integer> visited=new HashSet<>();

        pq.add(new Pair(k,0));

        

       while(!pq.isEmpty())
       {
            Pair curr=pq.poll();
            int u=curr.node;

            for(Pair nei:adj.get(curr.node))
            {
                int v=nei.node;

                if( curr.weight+nei.weight < dist[v])
                {
                    dist[v]= curr.weight+nei.weight;
                    pq.add(new Pair(v,dist[v]));
                }
            }
       }

       int max=Integer.MIN_VALUE;

       for(int i:dist) max=Math.max(i,max);

       return max == Integer.MAX_VALUE?-1:max;

    }
}