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
    HashSet<Integer> hm=new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        
        if(root==null) return false;

        int reqNum=k-root.val;

        if(hm.contains(reqNum)) return true;

        hm.add(root.val);

        boolean left=findTarget(root.left,k);
        boolean right=findTarget(root.right,k);

       return left||right;
    }
}