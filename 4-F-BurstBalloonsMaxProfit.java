// https://leetcode.com/problems/burst-balloons/
// Hint: https://www.youtube.com/watch?v=IFNibRVgFBo

class Solution {
    public int maxCoins(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[len][len];
        for(int d=0;d<len;d++) {
            for(int i=0;i<len-d;i++) {
                int j=i+d, max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++) {
                    int leftval=(k==i)?0:dp[i][k-1]; // Here k = left extreme so nothing is there on left of k so we take 0 else dp[i][k-1]
                    int rightval=(k==j)?0:dp[k+1][j]; // Here k = right extreme so nothing is there on right of k so we take 0 else dp[k+1][j]
                    int midval = (i==0?1:nums[i-1])*nums[k]*(j==len-1?1:nums[j+1]); // if i==0 or j==len-1, these are boundary value conditions 
                    // which means no balloons are left before i=0 or j=len-1 so we have taken it as 1 as mentioned in the question.
                    max=Math.max(max, leftval+midval+rightval);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][len-1];
    }
}
