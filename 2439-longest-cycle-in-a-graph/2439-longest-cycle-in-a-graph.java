import java.util.*;

class Solution {

    // max will store the length of the longest cycle found
    private int max = -1; // Initialize to -1 as per problem constraints for no cycle

    public int longestCycle(int[] edges) {
        int n = edges.length;

        // visited array to keep track of globally visited nodes across all DFS traversals
        // This prevents redundant re-processing of nodes that are part of already explored paths
        boolean[] globalVisited = new boolean[n];

        // For each node, we start a DFS if it hasn't been visited globally
        for (int i = 0; i < n; i++) {
            if (!globalVisited[i]) {
                // pathVisited stores the depth at which a node was visited *in the current DFS path*.
                // This is crucial for detecting cycles and calculating their length.
                // Initialize for each new DFS traversal.
                int[] pathVisited = new int[n];
                dfs(edges, globalVisited, pathVisited, i, 1); // Start depth from 1
            }
        }

        return max;
    }

    private void dfs(int[] edges, boolean[] globalVisited, int[] pathVisited, int curr, int depth) {
        // If the current node has been visited in the current DFS path (pathVisited[curr] != 0),
        // we've found a cycle!
        if (pathVisited[curr] != 0) {
            // Calculate the cycle length: current depth - depth at which 'curr' was first seen in this path
            max = Math.max(max, depth - pathVisited[curr]);
            return; // Cycle detected and processed, no need to go further in this path
        }

        // If the current node has been globally visited (part of another DFS traversal),
        // it means this path leads to an already explored component, but not necessarily a cycle *within this path*.
        // We can stop here to avoid redundant work.
        if (globalVisited[curr]) {
            return;
        }

        // Mark the current node as visited globally and in the current path
        globalVisited[curr] = true;
        pathVisited[curr] = depth;

        // Get the neighbor of the current node
        int neighbor = edges[curr];

        // If a neighbor exists (not -1)
        if (neighbor != -1) {
            dfs(edges, globalVisited, pathVisited, neighbor, depth + 1);
        }

        // Backtrack: Reset pathVisited for the current node.
        // This is crucial because this node might be part of another path that is yet to be explored
        // in a subsequent DFS call from a different starting node.
        // If we don't reset, it might incorrectly trigger a cycle detection for unrelated paths.
        pathVisited[curr] = 0;
    }
}