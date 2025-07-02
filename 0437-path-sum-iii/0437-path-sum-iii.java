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

    int count=0;
    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Long,Integer> prefixSum=new HashMap<>();

        prefixSum.put(0L,1);
        
        dfs(root,(long)targetSum,(long)0,prefixSum);

        return count;
    }

    void dfs(TreeNode root,long targetSum , Long currSum ,HashMap<Long,Integer> prefixSum)
    {
        if(root == null) return;

       currSum+=root.val;

       if(prefixSum.containsKey(currSum-targetSum))
       {
        count+=prefixSum.get(currSum-targetSum);
       }

       prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0)+1);

       dfs(root.left,targetSum,currSum,prefixSum);
       dfs(root.right,targetSum,currSum,prefixSum);

        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
    }

  
}