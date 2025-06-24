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
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> lst=new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                Node curr=q.poll();
                if(curr == null) continue;
                lst.add(curr.val);

                if(curr!=null)
                for(Node child:curr.children)
                {
                    if(child!=null)
                    q.add(child);
                }

            }

            if(lst.size()!=0)
            result.add(lst);

        }

        return result;
    }
}