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
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        tmp[0] = k;
        traverse(root, tmp);
        return tmp[1];
    }

    private static void traverse(TreeNode head, int[] res) {
        if (head == null) {
            return;
        }
        traverse(head.left, res);
        if (res[0] == 0) {
            return;
        }
        res[0] = res[0] - 1;
        if (res[0] == 0){
            res[1] = head.val;
            return;
        }
        traverse(head.right, res);
    }

    // public int kthSmallest(TreeNode root, int k) {
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode curr = root;
    //     int len = k;
    //     while (curr != null || !stack.isEmpty()) {
    //         while (curr != null) {
    //             stack.push(curr);
    //             curr = curr.left;
    //         }
    //         curr = stack.pop();
    //         len--;
    //         if (len == 0) {
    //             return curr.val;
    //         }
    //         curr = curr.right;
    //     }
    //     return -1;
    // }
}
