// User function Template for Java

class Solution {
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        // code here
        long[] segTree=new long[4*n];
        build(0,0,n-1,segTree,arr);
        List<Integer> res = new ArrayList<>();
        int idx=0;
        for(int i=0;i<2*q;i+=2){
            int l=queries[i]-1;
            int r=queries[i+1]-1;
            long ans=query(0,n-1,0,l,r,segTree);
            res.add((int) ans);
        }
        return res;
    }
    
    public static void build(int i, int l,int r, long[] segTree ,int[] arr){
        if(l==r){
            segTree[i]=arr[l];
            return;
        }
        int mid=(l+r)/2;
        build(2*i+1,l,mid,segTree,arr);
        build(2*i+2,mid+1,r,segTree,arr);
        segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }
    public static long query(int start, int end,int i, int l , int r ,long[] segTree){
        if(l>end || r<start )  return 0;
        if(l<=start && end<=r) return segTree[i];
        int mid = (start + end) / 2;
        return query(start,mid,2*i+1,l,r,segTree)+query(mid+1,end,2*i+2,l,r,segTree);
    }
}