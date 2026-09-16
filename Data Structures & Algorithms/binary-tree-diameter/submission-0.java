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

    private int longest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return longest;
    }

    private int helper(TreeNode root) {
        
        if (root == null) {
            return -1;
        }
        int leftHeight = helper(root.left) + 1;

        int rightHeight = helper(root.right) + 1;

        this.longest = Math.max(longest, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight);
    }
}
