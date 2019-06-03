package main;

import java.util.*;

public class LeetCode235 {
    public static void main(String... args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode result = root;
            if (result.left != null && result.left.val >= p.val && result.left.val <= p.val) {
                return lowestCommonAncestor(result.left, p, q);
            } else if (result.right != null && result.right.val >= p.val && result.right.val <= p.val) {
                return lowestCommonAncestor(result.right, p, q);
            } else {
                return result;
            }
        }
    }
}


