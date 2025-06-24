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

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        dfs(root,targetSum,new ArrayList<>());
        return result;
    }

    void dfs(TreeNode root,int targetSum,List<Integer> curr)
    {
        if(root == null) return;

        curr.add(root.val);

        if(root.val == targetSum && root.left == null && root.right == null)
        {
            result.add(new ArrayList<>(curr));
        }

        dfs(root.left,targetSum-root.val,curr);
        dfs(root.right,targetSum-root.val,curr);
    curr.remove(curr.size()-1);


        

    }
}