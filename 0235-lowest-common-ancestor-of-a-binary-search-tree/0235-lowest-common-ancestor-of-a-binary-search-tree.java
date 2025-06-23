/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ancestor=null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        if(ancestor != null)
        System.out.println(ancestor.val);
        return ancestor;
    }

    boolean dfs(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return false;

        boolean curr = (root == q) || (root == p);
        boolean left = dfs(root.left,p,q);
        boolean right=dfs(root.right,p,q);

        if(left && right){
            ancestor=root;
        }
         if(curr&&left || curr&&right){
            ancestor=root;
        }

        return curr||left||right;
        
    }
}