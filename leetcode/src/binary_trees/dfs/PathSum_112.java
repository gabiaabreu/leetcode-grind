package binary_trees.dfs;

import binary_trees.TreeNode;

public class PathSum_112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );

//                 5
//                / \
//               4   8
//              /   / \
//             11  13  4
//            /  \      \
//           7    2      1

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // got to leaf - no childrens
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // i cant have currentSum to keep track, so I must take current node value off of targetSum
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
