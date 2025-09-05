class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] i : prerequisites) {
            adj.get(i[0]).add(i[1]);
        }
        
        boolean[][] isReachable = new boolean[numCourses][numCourses];

        for(int i = 0; i < numCourses; i++) {
            bfs(adj, isReachable, i, numCourses);
        }

        List<Boolean> result = new ArrayList<>();
        for(int[] i: queries) {
            result.add(isReachable[i[0]][i[1]]);
        }

        return result;
    }

    void bfs(List<List<Integer>> adj, boolean[][] isReachable, int curr, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];  

        q.add(curr);
        visited[curr] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int nei : adj.get(node)) {
                if (!visited[nei]) {         
                    isReachable[curr][nei] = true;
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
}
