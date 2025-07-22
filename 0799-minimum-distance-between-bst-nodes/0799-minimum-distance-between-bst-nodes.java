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

        List<Integer> lst=new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        
        dfs(root);
        int min=Integer.MAX_VALUE;

        for(int i=0;i<lst.size()-1;i++)
        {
            min=Math.min(lst.get(i+1)-lst.get(i),min);
        }
        return min;
    }

    void dfs(TreeNode root)
    {
        if(root == null) return;

        dfs(root.left);
        lst.add(root.val);
        dfs(root.right);
    }
}