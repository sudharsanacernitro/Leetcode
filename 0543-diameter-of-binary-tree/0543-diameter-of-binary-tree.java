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

    int diameter=0;

    public int diameterOfBinaryTree(TreeNode root) {
        int s=dfs(root);
        System.out.println(s);
        return diameter;
    }

    int dfs(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);

         diameter= Math.max(left+right,diameter);


        return 1+Math.max(left,right);
    }
}