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

    HashMap<Integer,Integer> hm=new HashMap<>();
    int maxOccurance=0;

    public int[] findFrequentTreeSum(TreeNode root) {
        
        List<Integer> result=new ArrayList<>();

        dfs(root);


        for(int key:hm.keySet())
        {
            if(hm.get(key) == maxOccurance)
            {
                result.add(key);
            }
        }

        System.out.println(result.toString());

        int[] finResult=new int[result.size()];

        for(int i=0;i<result.size();i++) finResult[i]=result.get(i);

        return  finResult;
    }

    int dfs(TreeNode root)
    {
        if(root == null) return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);

        int sum=left+right+root.val;

        if(!hm.containsKey(sum))
        {
            hm.put(sum,1);
        }
        else
        { hm.put(sum,hm.get(sum)+1);
        }

         maxOccurance=Math.max(maxOccurance,hm.get(sum));


        return sum;
    }
}