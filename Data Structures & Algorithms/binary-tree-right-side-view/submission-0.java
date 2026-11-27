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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> rightView = new ArrayList<>();

        if (root == null) {
            return rightView;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int currLevelLen = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < currLevelLen; i++) {

                TreeNode node = queue.poll();
                currLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            rightView.add(currLevel.getLast());
        }

        return rightView;
    }
}
