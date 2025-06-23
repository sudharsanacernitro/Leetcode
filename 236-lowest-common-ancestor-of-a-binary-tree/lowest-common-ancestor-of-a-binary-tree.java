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

        return ancestor;
    }

    boolean dfs(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root == null) return false;

        boolean curr=(root == p) || (root == q);

        boolean right=dfs(root.left,p,q);
        boolean left=dfs(root.right,p,q);

        if(right && left)
        {
            ancestor=root;
        }

        if(curr && right) ancestor=root;
        else if(curr && left) ancestor=root;

        return curr||left||right;
    }
}