class Solution
{
    public int[] productExceptSelf(int[] nums) 
    {
        int[] answer=new int[nums.length];
        int prefix=1;
        for(int i=0;i<nums.length;i++)
        {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int suffix=1;
        for(int i=nums.length-1;i>-1;i--)
        {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
    return answer;  
    }
}




