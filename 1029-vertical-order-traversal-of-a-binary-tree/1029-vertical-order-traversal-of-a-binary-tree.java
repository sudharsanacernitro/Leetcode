class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        class Node {
            TreeNode root;
            int index, row;

            Node(TreeNode root, int index, int row) {
                this.index = index;
                this.row = row;
                this.root = root;
            }
        }

        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        HashMap<Integer, List<int[]>> hm = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                int index = curr.index;
                int row = curr.row;
                TreeNode c = curr.root;

                minIndex = Math.min(index, minIndex);
                maxIndex = Math.max(index, maxIndex);

                hm.putIfAbsent(index, new ArrayList<>());
                hm.get(index).add(new int[]{row, c.val});

                if (c.left != null) q.add(new Node(c.left, index - 1, row + 1));
                if (c.right != null) q.add(new Node(c.right, index + 1, row + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = minIndex; i <= maxIndex; i++) {
            List<int[]> lst = hm.get(i);

            // Sort first by row, then by value
            Collections.sort(lst, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> col = new ArrayList<>();
            for (int[] pair : lst) {
                col.add(pair[1]);
            }
            result.add(col);
        }

        return result;
    }
}
