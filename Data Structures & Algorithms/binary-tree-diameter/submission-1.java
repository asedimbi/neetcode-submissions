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
    public int diameterOfBinaryTree(TreeNode root) {

        int[] diameterSoFar = new int[1];
        dfs(root, diameterSoFar);
        return diameterSoFar[0];
    }

    private int dfs( TreeNode root, int[] diameterSoFar){
        if (root == null){
            return 0;
        }

        int left = dfs(root.left, diameterSoFar);
        int right = dfs(root.right, diameterSoFar);
        diameterSoFar[0] = Math.max(diameterSoFar[0], left + right);
        return 1 + Math.max(left, right);

    }
}
