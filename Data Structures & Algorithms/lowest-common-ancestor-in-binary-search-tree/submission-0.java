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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p == null || q == null){
            return root;
        }

        Stack<TreeNode> pathToP = new Stack<>();
        Stack<TreeNode> pathToQ = new Stack<>();

        TreeNode lca = null;

        if(dfsToNode(root, p, pathToP) && dfsToNode(root, q, pathToQ)){
            while(!pathToP.isEmpty() && !pathToQ.isEmpty()){
                TreeNode a = pathToP.pop();
                TreeNode b = pathToQ.pop();

                if(a == b){
                    lca = a;
                }else{
                    return lca;
                }
            }
        }

        return lca;
        
    }

    private boolean dfsToNode(TreeNode root, TreeNode target, Stack<TreeNode> path){
        if(root == null)
            return false;

        if(root.val == target.val){
            path.push(root);
            return true;
        }

        if( dfsToNode(root.left, target, path) || dfsToNode(root.right, target, path) ){
            path.push(root);
            return true;
        }

        return false;
    }
}
