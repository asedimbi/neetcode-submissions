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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null){
            return true; //empty subtree is subset of all trees
        }

        boolean[] truth = new boolean[1];
        dfs(root, subRoot, truth); // just traverse, no need to return anything
        return truth[0];

    }

    private void dfs(TreeNode root, TreeNode subRoot, boolean[] truth){

        if(root == null) //we hit a leaf on main tree, go back
            return;
        
        if (root.val == subRoot.val){
            //we have a potential candidate node in main tree
            if(hasSameNodes(subRoot, root)){
                truth[0] = true;
                return;
            }     
        }

        //keep traversing until we find a potential candidate node
        dfs(root.left, subRoot, truth);
        dfs(root.right, subRoot, truth);
        
    }

    private boolean hasSameNodes(TreeNode subTreeNode, TreeNode mainTreeNode){
        if (subTreeNode == null || mainTreeNode == null) {
            return subTreeNode == mainTreeNode;
        }

        return (subTreeNode.val == mainTreeNode.val) 
                && hasSameNodes(subTreeNode.left, mainTreeNode.left) 
                && hasSameNodes(subTreeNode.right, mainTreeNode.right);

    }
}
