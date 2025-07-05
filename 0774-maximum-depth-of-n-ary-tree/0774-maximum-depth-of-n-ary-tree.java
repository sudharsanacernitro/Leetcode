/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    int depth=Integer.MIN_VALUE;

    public int maxDepth(Node root) {
        
        if(root == null) return 0;
        dfs(root,1);

        return depth;
    }

    void dfs(Node root,int currDepth)
    {
        if(root==null || root.children == null || root.children.size() == 0)
        {
            depth=Math.max(depth,currDepth);
            return;
        }

        for(Node child : root.children)
        {
            dfs(child,currDepth+1);
        }
    }
}