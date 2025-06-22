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
    
   
    public List<Integer> distanceK(TreeNode root, TreeNode target, int distance) {
        
        
        Map<TreeNode, List<TreeNode>> graph=treeToGraph(root);

        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> hs=new HashSet<>();

        List<Integer> result=new ArrayList<>();


        
           q.add(target);
           hs.add(target);

        int level=0;
        
        while(!q.isEmpty())
        {
            int size=q.size();

             if (level == distance) {
                for (TreeNode node : q) {
                    result.add(node.val);
                }
                return result;
            }

            for(int i=0;i<size;i++)
            {
                List<TreeNode> lst=  graph.getOrDefault(q.poll(),new ArrayList<>());
                for(TreeNode k:lst)
                {
                    if(!hs.contains(k))
                    {
                        q.add(k);
                        hs.add(k);

                    }
                }
            }


            level++;
        }

        

        return result;



    }

   public Map<TreeNode, List<TreeNode>> treeToGraph(TreeNode root) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        return graph;
    }

    // DFS to build the graph with parent-child undirected edges
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;

        graph.putIfAbsent(node, new ArrayList<>());

        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node); // undirected edge
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }


}