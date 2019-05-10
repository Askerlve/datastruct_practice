package com.askerlve.datastruct.tree;

/**
 * @author Askerlve
 * @Description: 给定一个二叉树，找出其最大深度
 * @date 2019/5/10上午9:58
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        return getBinaryLevel(root, 0);
    }

    public int getBinaryLevel(TreeNode tree, int index) {
        if (null == tree) {
            return index;
        }

        int maxleftLevel = 0;
        if (tree.left != null) {
            maxleftLevel = getBinaryLevel(tree.left, index + 1);
        }

        int maxRightLevel = 0;

        if (tree.right != null) {
            maxRightLevel = getBinaryLevel(tree.right, index + 1);
        }

        return Math.max(maxleftLevel, maxRightLevel) + 1;
    }

    public int getBinaryLevel(TreeNode tree) {
        return tree == null ? 0 : Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
