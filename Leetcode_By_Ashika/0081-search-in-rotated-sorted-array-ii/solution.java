class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private boolean binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) return false;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return true;

        // ⚠️ Handle duplicates
        if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
            // shrink both sides
            return binarySearch(nums, target, left + 1, right - 1);
        }

        // ✅ Left half is sorted
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return binarySearch(nums, target, left, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, right);
            }
        }
        // ✅ Right half is sorted
        else {
            if (nums[mid] < target && target <= nums[right]) {
                return binarySearch(nums, target, mid + 1, right);
            } else {
                return binarySearch(nums, target, left, mid - 1);
            }
        }
    }
}

