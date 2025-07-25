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
    int totalSum=0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        
        dfs(root,low,high);
        return totalSum;

    }

    void dfs(TreeNode root, int low, int high)
    {
        if(root == null ) return;

        if(root.val <= high && root.val >= low)
        totalSum+=root.val;

        dfs(root.left,low,high);
        dfs(root.right,low,high);
    }
}