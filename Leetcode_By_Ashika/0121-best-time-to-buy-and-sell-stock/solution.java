class Solution {
    public int maxProfit(int[] prices) {
        int buyP=prices[0]; int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buyP){
                 int profit=prices[i]-buyP;
                  maxProfit=Math.max(profit,maxProfit);
               
            }else{
                  buyP=prices[i];
              
               }
            }
                
            
        
    return maxProfit;
   }
}
