class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        int m=s1.length();
        int n=s2.length();
        int o=s3.length();
        int[][][] t=new int[m][n][o];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<o;k++){
                    t[i][j][k]=-1;
                }
            }
        }
        return helper(s1,s2,s3,0,0,0,t);
        
    }
    int helper(String s1, String s2, String s3,int i,int j,int k,int[][][] t){
        int m=s1.length();
        int n=s2.length();
        int o=s3.length();
        
        if(i==m || j==n || k==o) return 0;
        if(t[i][j][k]!=-1) return t[i][j][k];
        if((s1.charAt(i)==s2.charAt(j)) && (s2.charAt(j)==s3.charAt(k))){
            t[i][j][k]=1+ helper(s1,s2,s3,i+1,j+1,k+1,t);
        }
        else{
            t[i][j][k]= Math.max(helper(s1,s2,s3,i+1,j,k,t),
            Math.max(helper(s1,s2,s3,i,j+1,k,t),helper(s1,s2,s3,i,j,k+1,t)
            )
           );  
        }
    return t[i][j][k];
    }
}