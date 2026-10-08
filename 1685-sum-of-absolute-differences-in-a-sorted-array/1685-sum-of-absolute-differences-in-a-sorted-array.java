class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate total sum of all elements
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int current = nums[i];

            // Sum of differences with elements on the left
            int left = current * i - leftSum;

            // Sum of differences with elements on the right
            int right = (totalSum - leftSum - current)
                      - current * (n - i - 1);

            result[i] = left + right;

            // Add current element to left sum
            leftSum += current;
        }

        return result;
    }
}