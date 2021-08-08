// https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] a) {
        int l=a.length;
        int[] s=new int[l];
        // p[] : position index
        //int[] p=new int[l];
        s[0]=a[0];
        //p[0]=0;
        for(int i=1;i<l;i++) {
            if(s[i-1]>0){
                s[i]=a[i]+s[i-1];
                //p[i]=p[i-1];
            }
            else{
                s[i]=a[i];
                //p[i]=i;
            }
        }
        int maxsum=s[0];
        for(int i=1;i<l;i++){
            if(s[i]>maxsum){
                maxsum=s[i];
            }
        }
        return maxsum;
    }
}

