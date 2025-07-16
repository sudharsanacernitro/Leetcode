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

    public TreeNode convertBST(TreeNode root) {
        
        dfs(root,0,false);
        return root;
    }

    void dfs(TreeNode root,int val,boolean isLeft)
    {
        if(root == null)
        return ;

        dfs(root.right,root.val,false);

        root.val+=sum;
        sum=root.val;
       
        dfs(root.left,root.val,true);


    }
}