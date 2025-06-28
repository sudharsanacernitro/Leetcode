import java.util.*;

class Solution {

    class Pair {
        int node, cost, stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2], 0));
        }

        // dist[i][j] = min cost to reach node i with j stops
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Pair(src, 0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int cost = curr.cost;
            int stops = curr.stops;

            if (stops > k) continue;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int newCost = cost + neighbor.cost;

                // If a cheaper cost is found with fewer stops, update and continue
                if (newCost < dist[nextNode][stops + 1]) {
                    dist[nextNode][stops + 1] = newCost;
                    pq.offer(new Pair(nextNode, newCost, stops + 1));
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, dist[dst][i]);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
