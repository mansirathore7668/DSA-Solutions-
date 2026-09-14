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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    private boolean isMirror(TreeNode left,TreeNode right){
        //both are null
        if(left==null && right==null) return true;
            
        //only one is null
        if(left==null || right==null) return false;

        //if values are different
        if(left.val!=right.val) return false;

        //Compare opposite sites
        boolean outer =isMirror(left.left,right.right);
        boolean inner=isMirror(left.right,right.left);

        return outer&&inner;
    }
}