class Solution {
    public static int removeDuplicates(int[] nums) {
            int i = 0;  // i tracks the index of the modified array
            for(int n : nums) {  // Iterate through each element n in nums
                if(i < 2 || n != nums[i-2]) {
                   nums[i++] = n;  // Copy element to new position and increase i
                 }
            }

            return i;
        }
}
