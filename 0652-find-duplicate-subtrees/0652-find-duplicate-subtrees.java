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
    HashMap<String,Integer> hm=new HashMap<>();
    List<TreeNode> result=new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        findDuplicate(root);
        // System.out.println(result.toString());
        return result;
    }

   

    public String findDuplicate(TreeNode root)
    {
        
        if(root == null)
        {
            return "#";
        }

        String left=findDuplicate(root.left);
        String right=findDuplicate(root.right);

        String serial=root.val+"-"+left+"-"+right;

        hm.put(serial,hm.getOrDefault(serial,0)+1);

        if(hm.get(serial) == 2)
        {
            result.add(root);
        }

        return serial;

    }
}