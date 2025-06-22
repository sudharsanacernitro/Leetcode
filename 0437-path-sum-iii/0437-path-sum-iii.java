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

    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        
        dfs(root,(long)targetSum);
        System.out.println(count);
        return count;
    }

    void dfs(TreeNode root,long targetSum)
    {
        if(root == null) return;

        dfs(root.left,targetSum);
        isValid(root,targetSum);
        dfs(root.right,targetSum);
    }

    void  isValid(TreeNode root,long targetSum)
    {
        if(root == null) return;

        if(targetSum == root.val) count++;

        isValid(root.left,targetSum-root.val);
        isValid(root.right,targetSum-root.val);

    }
}