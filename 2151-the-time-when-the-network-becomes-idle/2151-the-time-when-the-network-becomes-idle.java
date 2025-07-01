class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        class Pair
        {
            int node,weight;
            Pair(int node,int weight)
            {
                this.node=node;
                this.weight=weight;
            }
        }
        int n=patience.length;

        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i[]:edges)
        {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);

        }

        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(0);

        while(!pq.isEmpty())
        {
            int u=pq.poll();

            for(int nei:adj.get(u))
            {
                int v=nei;
                if(dist[u]+1 < dist[v])
                {
                    dist[v]=dist[u]+1;
                    pq.add(v);
                }
            }
        }

        int maxDelay=Integer.MIN_VALUE;

        for(int i=0;i<patience.length;i++)
        {
            if (patience[i] == 0) continue;
            int last_sent_time = ((2 * dist[i] - 1) / patience[i]) * patience[i];
            int total_time = last_sent_time + 2 * dist[i];

            maxDelay=Math.max(maxDelay,total_time);

        }

        return (maxDelay+1);
    }
}