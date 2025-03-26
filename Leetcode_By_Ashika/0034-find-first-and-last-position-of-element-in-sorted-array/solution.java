class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;

        // Finding the first and last occurrence using a single pass
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i; // First occurrence
                }
                last = i; // Update last occurrence
            }
        }

        return new int[]{first, last};
    }
}

