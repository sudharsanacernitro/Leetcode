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
            String temp="";


    public String tree2str(TreeNode root) {
        temp=preorder(root);
        return temp;
    }

    String preorder(TreeNode root)
    {
        if(root == null) return "";

        String left=preorder(root.left);
        String right=preorder(root.right);

        if(!left.equals("") && !right.equals(""))
        return root.val+"("+left+")"+"("+right+")";

        else if(!left.equals(""))
        return root.val+"("+left+")";

        else if(!right.equals(""))
        return root.val+"()"+"("+right+")";

        else return root.val+"";


    }
}