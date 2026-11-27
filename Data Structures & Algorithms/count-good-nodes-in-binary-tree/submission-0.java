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
    
    public int goodNodes(TreeNode root) {

        if (root == null)
            return 0;

        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int maxOnTheWay) {

        if (root == null)
            return 0;

        int count = 0;

        if (root.val >= maxOnTheWay) {
            count = 1;
            maxOnTheWay = root.val;
        }

        return count
                + dfs(root.left, maxOnTheWay)
                + dfs(root.right, maxOnTheWay);
    }
}
