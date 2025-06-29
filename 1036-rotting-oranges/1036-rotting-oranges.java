class Solution {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int node = 0; // count of fresh oranges

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
                if (grid[i][j] == 1)
                    node++;
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean changed = false;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int x = curr.x, y = curr.y;

                if (x + 1 < n && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    q.add(new Pair(x + 1, y));
                    node--;
                    changed = true;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    q.add(new Pair(x - 1, y));
                    node--;
                    changed = true;
                }
                if (y + 1 < m && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    q.add(new Pair(x, y + 1));
                    node--;
                    changed = true;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    q.add(new Pair(x, y - 1));
                    node--;
                    changed = true;
                }
            }

            if (changed) time++;
        }

        return node == 0 ? time : -1;
    }
}
