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

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBalanced;
    }

    public int helper(TreeNode node) {
        if (node == null || !isBalanced) return 0;
        
        int leftHeight = helper(node.left) + 1;

        int rightHeight = helper(node.right) + 1;

        int heightDiff = Math.abs(leftHeight - rightHeight);

        if (heightDiff > 1) isBalanced = false;

        return Math.max(leftHeight, rightHeight);

    }
}
