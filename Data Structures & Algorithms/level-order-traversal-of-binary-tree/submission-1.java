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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }

    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        TreeNode curr;
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for (int i = 0; i <= len - 1; i++) {
                curr = queue.removeFirst();
                System.out.print(curr.val + " ");
                subRes.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(subRes);
            level = level + 1;
            System.out.println();
        }
        return res;
    }
}
