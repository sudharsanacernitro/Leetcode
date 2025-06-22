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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);

        int level=0;

        while(!q.isEmpty())
        {
            int size=q.size();

            List<TreeNode> lst=new ArrayList<>();
            
            if(level % 2 ==0)
            {
                    for(int i=0;i<size;i++)
                    {
                        TreeNode curr = q.poll();
                        if(curr.left != null) q.add(curr.left);
                        if(curr.right != null) q.add(curr.right);
            
                    }
            }
            else
            {
                   for(int i=0;i<size;i++)
                    {
                        TreeNode curr = q.poll();
                        lst.add(curr);
                        if(curr.left != null) q.add(curr.left);
                        if(curr.right != null) q.add(curr.right);
            
                    }

                    for(int i=0;i<(size/2);i++)
                    {
                        int temp=lst.get(i).val;
                        lst.get(i).val=lst.get(size-1-i).val;
                        lst.get(size-1-i).val=temp;
                    }
              

            }

            level++;
        }
        return root;
    }
}