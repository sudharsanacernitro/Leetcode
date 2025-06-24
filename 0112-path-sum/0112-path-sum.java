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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return dfs(root,targetSum);
    }

    boolean dfs(TreeNode root, int targetSum)
    {
        if(root == null) return false;

         if(targetSum == root.val && root.left == null && root.right == null)
        {
            return true;
        }

        boolean right =dfs(root.left,targetSum-root.val);

       
       boolean left = dfs(root.right,targetSum-root.val);

       if(right || left) return true;

        return false;

    }
}