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
    public boolean isBalanced(TreeNode root) {
        return solve(root) != -1;
    }

    public int solve(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = solve(head.left);
        if (left == -1) {
            return -1;
        }
        int right = solve(head.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return combine(left, right);
    }
    
    private int combine(int left, int right) {
        return 1 + Math.max(left, right);
    }
}
