class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adjBi = new ArrayList<>();
        Set<String> directedEdges = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adjBi.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int from = edge[0], to = edge[1];
            adjBi.get(from).add(to);
            adjBi.get(to).add(from);

            directedEdges.add(from + "->" + to);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int neighbor : adjBi.get(curr)) {
                if (!visited[neighbor]) {
                    if (directedEdges.contains(curr + "->" + neighbor)) {
                        count++;
                    }
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        return count;
    }
}
