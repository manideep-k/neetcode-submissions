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
        return checkBalance(root).isBalanced();
    }

    public Pair checkBalance(TreeNode head) {
        if (head == null) {
            return new Pair(true, 0);
        }
        Pair left = checkBalance(head.left);
        Pair right = checkBalance(head.right);
        boolean isBalanced = (left.isBalanced && right.isBalanced) && (Math.abs(left.height - right.height) <= 1);
        return new Pair(isBalanced, Math.max(left.height, right.height) + 1);
    }

    public record Pair(boolean isBalanced, int height) {

    }
}
