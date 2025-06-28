class Solution {

    boolean[] visited;

    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        List<Integer> soc = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int[] count = new int[1]; // to hold size of current component
            dfs(adjList, i, count);
            soc.add(count[0]);
        }

        // Count all possible unreachable pairs
        long mul = 0;
        long total = 0;
        for (int size : soc) {
            mul += (long) size * total;
            total += size;
        }

        return mul;
    }

    void dfs(List<List<Integer>> adjList, int curr, int[] count) {
        visited[curr] = true;
        count[0]++;

        for (int neighbor : adjList.get(curr)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, count);
            }
        }
    }
}
