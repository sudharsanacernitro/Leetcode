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
    public int deepestLeavesSum(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        int rootSum=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            int sum=0;

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if(curr == null) continue;

                sum+=curr.val;

                if(curr.right != null)q.add(curr.right);
                if(curr.left !=null)q.add(curr.left);
            }
            rootSum=sum;
        }

        return rootSum;
    }
}