class Solution {
    public int removeDuplicates(int[] nums) {
                int i = 0; // Slow pointer
        for (int j = 1; j < nums.length; j++) { // Fast pointer
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1; 
    }
}
