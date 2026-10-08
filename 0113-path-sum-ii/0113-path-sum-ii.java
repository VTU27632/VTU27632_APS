import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        findPaths(root, targetSum, path, result);

        return result;
    }

    public void findPaths(TreeNode root, int targetSum,
                          List<Integer> path,
                          List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        path.add(root.val);

        // Check if it is a leaf
        if (root.left == null && root.right == null &&
            targetSum == root.val) {

            result.add(new ArrayList<>(path));
        }

        // Continue searching
        findPaths(root.left, targetSum - root.val, path, result);
        findPaths(root.right, targetSum - root.val, path, result);

        // Backtrack
        path.remove(path.size() - 1);
    }
}