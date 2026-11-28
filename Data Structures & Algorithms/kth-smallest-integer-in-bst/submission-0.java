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
        
    List<Integer> sorted = new ArrayList<>();

        inorder(root, sorted);

        return sorted.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> sorted) {

        if (root == null)
            return;

        inorder(root.left, sorted);

        sorted.add(root.val);

        inorder(root.right, sorted);
    }
}
