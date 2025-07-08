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

    public int widthOfBinaryTree(TreeNode root) {
      
      class Pair
      {     TreeNode node;
            int index;
        Pair(TreeNode node,int index)
        {
            this.node=node;
            this.index=index;
        }
      }
      
      Queue<Pair> q=new LinkedList<>();

      int level=1;

        root.val=0;

    q.add(new Pair(root,1));
        int maxWidth=1;

      while(!q.isEmpty())
      {
        int size=q.size();
        int start=q.peek().index;
        int end=q.peek().index;

        for(int i=0;i<size;i++)
        {
            Pair curr=q.poll();

            end=curr.index;

            if(curr.node.left!=null) q.add(new Pair(curr.node.left,curr.index*2));
            if(curr.node.right!=null) q.add(new Pair(curr.node.right,( curr.index*2 )+1));
    
        }

        maxWidth=Math.max(maxWidth,end-start+1);
      }
      return maxWidth;
    }

  
}