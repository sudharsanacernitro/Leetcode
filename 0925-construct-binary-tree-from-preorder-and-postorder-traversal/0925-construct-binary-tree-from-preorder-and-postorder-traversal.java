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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);

        if (preStart == preEnd) return root;

        int leftRootVal = pre[preStart + 1];
        int indexInPost = postStart;

        while (post[indexInPost] != leftRootVal) indexInPost++;

        int leftSize = indexInPost - postStart + 1;

        root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, indexInPost);
        root.right = build(pre, preStart + leftSize + 1, preEnd, post, indexInPost + 1, postEnd - 1);

        return root;
    }
}
