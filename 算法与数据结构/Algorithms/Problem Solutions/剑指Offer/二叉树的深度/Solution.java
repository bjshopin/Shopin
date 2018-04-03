/**
 * @author littledream1502@gmail.com
 * @date 2018/2/10
 * @desc 求二叉树深度
 */
public class Solution {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new Solution().TreeDepth(root));
    }
}

class TreeNode {

    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int x) {
        this.val = x;
    }
}