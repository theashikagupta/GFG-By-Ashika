class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length; int n=matrix[0].length;
        int sr=0; int er=m-1;
        while(sr<=er){
            int midrow=sr+(er-sr)/2;
            if(matrix[midrow][0]<=target && target<=matrix[midrow][n-1]){
                return searchInRow(target,matrix,midrow);
            }else if(target<matrix[midrow][0]){
                er=midrow-1;
            }else{
                sr=midrow+1;
            }
        }
        return false;
    }
    public static boolean searchInRow(int target,int[][] matrix,int midrow){
        int si=0 ; int ei=matrix[midrow].length-1;
        while(si<=ei){
            int midcol=si+(ei-si)/2;
            if(matrix[midrow][midcol]==target){
                return true;
            }else if(target<matrix[midrow][midcol]){
                ei=midcol-1;
            }else{
                si=midcol+1;
            }
            
        }
        return false;
    }
}
