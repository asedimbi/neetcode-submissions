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

        List<List<Integer>> levels = new ArrayList<>();

        if(root == null){
            return levels;
        } 

        Deque<TreeNode> queueOfNodes = new ArrayDeque<>();
        
        queueOfNodes.offer(root);
        int currLevelLen = 1;
        int nextLevelLen = 0;

        while(!queueOfNodes.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();

            for(int i=0; i<currLevelLen ; i++){
                TreeNode a = queueOfNodes.pop();
                currLevel.add(a.val);
                if(a.left != null){
                    queueOfNodes.offer(a.left);
                    nextLevelLen++;
                }
                if(a.right != null){
                    queueOfNodes.offer(a.right);
                    nextLevelLen++;
                }    
            }

            levels.add(currLevel);
            currLevelLen = nextLevelLen;
            nextLevelLen = 0;
        }

        return levels;
    }
}
