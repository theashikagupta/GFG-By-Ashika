class Solution {
    public int fib(int n) {
        
        if(n==0){
            return 0;
        }
        else{
            int a=0;
            int b=1;
            int count=2;
            while(count<=n){
                int temp=b;
                b=a+b;
                a=temp;
                count++;

                
               
            }return b;
        }
    }
}
