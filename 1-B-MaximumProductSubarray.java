// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] a) {
        int l=a.length;
        int[] mpp=new int[l];//maxm positive product
        int[] mnp=new int[l];//maxm negative product
        //int[] mppi=new int[l];//maxm positive product index
        //int[] mnpi=new int[l];//maxm negative product index
        mpp[0]=a[0];
        //mppi[0]=0;
        mnp[0]=a[0];
        //mnpi[0]=0;
        for(int i=1;i<l;i++){
            mpp[i]=Math.max(a[i],Math.max(a[i]*mpp[i-1], a[i]*mnp[i-1]));
            mnp[i]=Math.min(a[i],Math.min(a[i]*mpp[i-1], a[i]*mnp[i-1]));
        }
        int maxp=mpp[0];
        for(int i=1;i<l;i++){
            if(mpp[i]>maxp)
                maxp=mpp[i];
        }
        return maxp;
    }
}

/* Similar Problems:
1. Maximum Product Subarray Elements
2. Minimum Product Subarray
3. Minimum Product Subarray Elements
*/
