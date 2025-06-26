/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode targetM = null;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        findTarget(root, subRoot);

        if (targetM == null) return false;

        return true;
    }

    void findTarget(TreeNode root, TreeNode target) {
        if (root == null) return;

        if (root.val == target.val && dfs(root, target)) {
            targetM = root;
            return;
        }

        findTarget(root.left, target);
        findTarget(root.right, target);
    }

    boolean dfs(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        if (tree1.val != tree2.val) return false;

        return dfs(tree1.left, tree2.left) && dfs(tree1.right, tree2.right);
    }
}
