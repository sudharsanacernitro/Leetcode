class Solution {
    public TreeNode pruneTree(TreeNode root) {

        if(root.val == 0 && root.left == null && root.right ==null) return null;
        dfs(root); 

        if(root.left == null && root.right!=null)
        {
            if(root.val == 0 && root.right.val == 0 && root.right.left == null && root.right.right == null) return null;
        }
        return root; // Ensure root is pruned if necessary
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        Pruning(root, root.left, 0);
        Pruning(root, root.right, 1);
        dfs(root.right);
    }

    void Pruning(TreeNode parent, TreeNode root, int child) {
        if (root == null) return;

        if (root.left == null && root.right == null && root.val == 0) {

            if (child == 1 ) parent.right = null;
            else parent.left = null;
            return;
        }

        Pruning(root, root.left, 0);
        Pruning(root, root.right, 1);
    }

    
}
