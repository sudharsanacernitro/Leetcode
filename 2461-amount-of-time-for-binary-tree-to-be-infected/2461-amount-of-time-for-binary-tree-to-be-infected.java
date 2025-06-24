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

    int depth=0;

    public int amountOfTime(TreeNode root, int start) {
       
        dfs(root,start);
        System.out.println(depth);

        return depth;
    }

    int dfs(TreeNode root , int start)
    {
        if(root == null) return -1;

        if(root.val == start)
        {
            maxDepth(root,0);
            return 1;
        }

       int left=dfs(root.left,start);

       if(left > 0)
       {
            maxDepth(root.right,left+1);

            depth=Math.max(left,depth);

            return 1+left;
       }

       int right=dfs(root.right,start);

       if(right > 0)
       {
        maxDepth(root.left,right+1);
        depth=Math.max(right,depth);
        return 1+right;
       }

       return -1;


    }

void maxDepth(TreeNode root,int time)
    {
        if(root == null) return ;
        depth=Math.max(depth,time);

        maxDepth(root.left,time+1);
        maxDepth(root.right,time+1);


    }



}