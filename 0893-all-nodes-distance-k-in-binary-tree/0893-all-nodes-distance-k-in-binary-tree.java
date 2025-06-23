/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    HashSet<Integer> result = new HashSet<>();

   
    public List<Integer> distanceK(TreeNode root, TreeNode target, int distance) {
        
        
        computeResult(target,distance);

        target.left=null;
        target.right=null;
        root = makeNewRoot(root,target);

        computeResult(root,distance);

        return new ArrayList<>(result);
    }

    public void computeResult(TreeNode root, int distance)
    {

       Queue<TreeNode> q=new LinkedList<>();

       q.add(root);

        int level=0;
       while(!q.isEmpty())
       {
        int size=q.size();

        if(level == distance)
        {
            for(TreeNode curr : q)
            {
                result.add(curr.val);
            } 
            break;
            
        }
        for(int i=0;i<size;i++)
        {
            TreeNode curr=q.poll();

            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);

        }
        level++;
       }

    }


    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == target) return true;
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode makeNewRoot(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        findPath(root, target, path);

        // Reversing the path
        for (int i = path.size() - 1; i > 0; i--) {
            TreeNode child = path.get(i);
            TreeNode parent = path.get(i - 1);

            // Detach and reverse the parent-child relationship
            if (parent.left == child) parent.left = null;
            else parent.right = null;

            if (child.left == null) child.left = parent;
            else child.right = parent;
        }

        return target;  // Now target is new root
    }

  


}