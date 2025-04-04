// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums); 
//         int n=nums.length; 
//         int ans=nums[0];
//          int freq=1;
//          for (int i = 1; i < n; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 freq++; 
//             } else {
//                 freq = 1;
//                  ans = nums[i]; 
//             }
            
//             if (freq > n/2) { 
//                 return ans;
               
//             }
//         }
        
       
//         return ans;
//     }
// }

class Solution{
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count=map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i],count);

            if(map.get(nums[i])>n/2){
                return nums[i];
            }
        }return -1;
    }
}


