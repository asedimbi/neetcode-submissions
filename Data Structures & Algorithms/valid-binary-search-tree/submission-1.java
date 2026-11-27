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
     public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        boolean[] validity = {true};

        dfsCheck(root, validity);

        return validity[0];
    }

    private int[] dfsCheck(TreeNode root, boolean[] validity) {

        int subtreeMax = root.val;
        int subtreeMin = root.val;

        if (root.left != null) {

            int[] left = dfsCheck(root.left, validity);

            if (root.val <= left[0])
                validity[0] = false;

            subtreeMax = Math.max(subtreeMax, left[0]);
            subtreeMin = Math.min(subtreeMin, left[1]);
        }

        if (root.right != null) {

            int[] right = dfsCheck(root.right, validity);

            if (root.val >= right[1])
                validity[0] = false;

            subtreeMax = Math.max(subtreeMax, right[0]);
            subtreeMin = Math.min(subtreeMin, right[1]);
        }

        return new int[]{subtreeMax, subtreeMin};
    }
}