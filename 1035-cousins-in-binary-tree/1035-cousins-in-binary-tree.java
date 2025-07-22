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

    List<List<Integer>> lst=new ArrayList<>();
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            boolean xFound=false,yFound=false;

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)) {
                        return false; // same parent → not cousins
                    }
                }

                if(curr.left!=null)
                {
                    if(curr.left.val == x ) xFound=true;
                    if(curr.left.val == y) yFound=true;

                    q.add(curr.left);
                } 
                if(curr.right!=null)
                {
                    if(curr.right.val == x ) xFound=true;
                    if(curr.right.val == y) yFound=true;
                    q.add(curr.right);
                } 

                
            }

            if(xFound && yFound) return true;
        }
        return false;
    }
}