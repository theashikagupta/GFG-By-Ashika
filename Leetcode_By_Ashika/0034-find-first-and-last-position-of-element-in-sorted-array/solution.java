class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[] {first, last};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                index = mid;       // store index
                right = mid - 1;   // go left to find earlier index
            } else if (nums[mid] < target) {
                left = mid + 1;    // go right
            } else {
                right = mid - 1;   // go left
            }
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                index = mid;       // store index
                left = mid + 1;    // go right to find later index
            } else if (nums[mid] < target) {
                left = mid + 1;    // go right
            } else {
                right = mid - 1;   // go left
            }
        }
        return index;
    }
}

