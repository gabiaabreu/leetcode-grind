package binary_trees.dfs;

import binary_trees.TreeNode;

public class MaximumDepthBinaryTree_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        System.out.println(maxDepth(root));

//                 3
//                / \
//               9   20
//                  /  \
//                 15   7
    }

    public static int maxDepth(TreeNode root) {
        // base case
        // if node == null, end of current branch
        if (root == null) return 0;

        // recursive case
        // return 1 (current not null node) + max(left or right branch)
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
