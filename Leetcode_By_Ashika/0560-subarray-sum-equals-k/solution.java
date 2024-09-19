import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int cumSum = 0;
        map.put(0, 1);  // Handle the case when the subarray starts from index 0
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];

            if (map.containsKey(cumSum - k)) {
                result += map.get(cumSum - k); // Add the count of subarrays with sum `cumSum - k`
            }

            // Increment the count of `cumSum` in the map
            map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
        }
        return result;
    }
}

