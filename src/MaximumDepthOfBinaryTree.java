/**
 * Created by myc on 4/26/16.
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode a0 = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        a0.left =a1;
        a1.left=a2;
        a2.left=a3;

        MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();
        System.out.println(test.maxDepth(a0));

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
