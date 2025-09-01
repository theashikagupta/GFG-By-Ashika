class Solution {
    public int subarraySum(int[] nums, int k) {
        // //Brute force
        // int sum=0;
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         if(sum==k){
        //             count++;
        //         }

        //     }
        //     sum=0;
        // }return count;
        //Optimal soln
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // base case: prefix sum 0 appears once

        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;

            // check if there exists a prefix sum such that currSum - prefixSum = k
            if (prefixCount.containsKey(currSum - k)) {
                count += prefixCount.get(currSum - k);
            }

            // update current prefix sum frequency
            prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        }

        return count;

    }
}


