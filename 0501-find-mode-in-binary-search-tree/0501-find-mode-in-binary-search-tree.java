class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        dfs(root, hm);

        int maxFreq = 0;
        for (int freq : hm.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }

        // Convert list to array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }

        return result;
    }

    public void dfs(TreeNode root, HashMap<Integer, Integer> hm) {
        if (root == null) return;

        dfs(root.left, hm);
        hm.put(root.val, hm.getOrDefault(root.val, 0) + 1);
        dfs(root.right, hm);
    }
}
