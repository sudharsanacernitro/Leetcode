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

    public int rob(TreeNode root) {
      
      HashMap<TreeNode,Integer> memo=new HashMap<>();

      return dfs(root,memo);
    }

    int dfs(TreeNode root, HashMap<TreeNode,Integer> memo)
    {
        if(root == null) return 0;

    if(memo.containsKey(root)) return memo.get(root);

    int sum=0;

    if(root.left != null)
    {
        sum+=dfs(root.left.left,memo)+dfs(root.left.right,memo);
    }
    if(root.right != null)
    {
        sum+=dfs(root.right.left,memo)+dfs(root.right.right,memo);
    }

    int maxSum=Math.max(sum+root.val ,dfs(root.left,memo) + dfs(root.right,memo) );
    memo.put(root,maxSum);
    return maxSum;
    }
}