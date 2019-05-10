package com.askerlve.datastruct.tree;

/**
 * @author Askerlve
 * @Description: 给定一个二叉树，判断其是否是一个有效的二叉搜索树。假设一个二叉搜索树具有如下特征：
 * 1) 节点的左子树只包含小于当前节点的数。
 * 2) 节点的右子树只包含大于当前节点的数。
 * 3) 所有左子树和右子树自身必须也是二叉搜索树。
 * @date 2019/5/10上午10:05
 */
public class IsValidBST {

    int last = -Integer.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //验证左边
        if (isValidBST(root.left)) {
            //右子树只包含大于当前节点的数
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        private long pre = Long.MIN_VALUE;
        private boolean valid = true;

        public boolean isValidBST(TreeNode root) {
            inOrderTraversal(root);
            return valid;
        }

        private void inOrderTraversal(TreeNode root){
            if(valid && root != null){
                inOrderTraversal(root.left);

                if(root.val <= pre){
                    valid = false;
                }
                pre = root.val;

                inOrderTraversal(root.right);
            }
        }
    }

}
