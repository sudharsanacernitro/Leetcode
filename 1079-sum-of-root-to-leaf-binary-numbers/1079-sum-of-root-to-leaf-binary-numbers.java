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

    int sum=0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root,"");
        return sum;
    }

    void dfs(TreeNode root,String str)
    {
        if(root == null) return;

        str+=root.val;

        if( root.left == null && root.right == null) 
        {
            int integer=Integer.parseInt(str,2);
            sum+=integer;
            System.out.println(str);
            return;
        }

        dfs(root.left,str);

        dfs(root.right,str);

    }
}