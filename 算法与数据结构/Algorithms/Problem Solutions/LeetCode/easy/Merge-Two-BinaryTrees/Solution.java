package com.leetcode.easy.MergeTwoBinaryTrees;

import java.net.Socket;

/**
 * @author zhangyong
 * @date 2017/11/7
 * @desc
 * @url https://leetcode.com/problems/merge-two-binary-trees/description/
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        /**
         * 递归构建左右子树,每一个节点都单独地计算val然后结合;
         */
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}

