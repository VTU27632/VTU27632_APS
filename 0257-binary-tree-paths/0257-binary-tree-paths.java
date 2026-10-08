import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        findPaths(root, "", result);

        return result;
    }

    public void findPaths(TreeNode root, String path,
                          List<String> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        if (path.equals("")) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        // If leaf node, add path to result
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Visit left and right subtrees
        findPaths(root.left, path, result);
        findPaths(root.right, path, result);
    }
}