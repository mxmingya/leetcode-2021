package DP;

public class HouseRob3 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);

        return Math.max(res[0], res[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // [0] rob current
        // [1] rob last, current isnt robbed
        int[] arr = new int[2];
        arr[0] = root.val + left[1] + right[1];
        arr[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return arr;
    }
}
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