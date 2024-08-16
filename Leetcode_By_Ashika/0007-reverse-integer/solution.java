class Solution {
    public int reverse(int x) {
        int r, sum = 0;
        while (x != 0) {
            r = x % 10;
            //To check for the overflow 
            if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && r>7)){
                return 0;
            }
            if(sum<Integer.MIN_VALUE/10 || (sum==Integer.MIN_VALUE/10 && r<-8)){
                return 0;
            }
            //if not overflow then proceed further
            sum = (sum * 10) + r;
            x /= 10;
        }
        return sum;
    }
}
