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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack =new Stack<>();
        List<Integer>  lst=new ArrayList<>();
         TreeNode curr = root;

        // stack.push(root);

        while(!stack.isEmpty() || curr!=null)
        {
           while(curr != null)
           {
            stack.push(curr);
            curr=curr.left;
           }
            
            curr=stack.pop();

            if(curr == null) continue;

            lst.add(curr.val);

            curr=curr.right;


            
        }

        return lst;
    }
}