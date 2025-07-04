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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return recursion(nums,0,nums.length-1);
    }

    TreeNode recursion(int[] nums,int start,int end)
    {
        int rootIndex=getMax(nums,start,end);

        if(rootIndex == -1) return null;

        TreeNode root=new TreeNode(nums[rootIndex]);

        root.left=recursion(nums,start,rootIndex-1);
        root.right=recursion(nums,rootIndex+1,end);

        return root;
    }

    int getMax(int[] nums,int start,int end)
    {
        int max=Integer.MIN_VALUE;
        int maxIndex=-1;

        for(int i=start;i<=end;i++)
        {
            if(max < nums[i])
            {
                max=nums[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}