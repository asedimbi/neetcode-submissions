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

        //at any root
        //diff of left length and right length> 1 return false;

        boolean[] truth = new boolean[1];
        truth[0] = true;

        int height = dfs(root, truth);
        return truth[0];

    }

    private int dfs(TreeNode root, boolean[] truth){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left, truth);
        int right = dfs(root.right, truth);
        if(Math.abs(left - right) > 1){
            truth[0] = false;
        }
        return 1 + Math.max(left, right);
    }
}
