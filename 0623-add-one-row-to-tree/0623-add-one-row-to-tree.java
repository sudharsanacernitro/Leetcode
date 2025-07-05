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

    int val;
    public TreeNode addOneRow(TreeNode root, int value, int depth) {
        
        if(depth == 1)
        {
            TreeNode newRoot=new TreeNode(value);
            newRoot.left=root;
            return newRoot;
        }
        val=value;
        dfs(root,2,depth);

        return root;
    }

    void dfs(TreeNode root,int currDepth , int depth)
    {
        if(root == null) return ;

        if(currDepth == depth)
        {
            TreeNode left= root.left;
            TreeNode right=root.right;

            TreeNode newNode1=new TreeNode(val);
             TreeNode newNode2=new TreeNode(val);

            newNode1.left=left;

            root.left=newNode1;

            newNode2.right=right;

            root.right=newNode2;


        }

        dfs(root.left,currDepth+1,depth);
        dfs(root.right,currDepth+1,depth);

        return ;

    }
}