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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);

         List<List<Integer>> lst=new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int size=q.size();

            List<Integer> temp=new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr == null) continue;
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);

                if(curr.right != null) q.add(curr.right);
            }

            if(temp.size() != 0)
            lst.add(temp);
        }

        return lst;
    }
}