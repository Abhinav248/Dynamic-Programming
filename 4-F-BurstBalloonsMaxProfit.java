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
                    int leftval=(k==i)?0:dp[i][k-1];
                    int rightval=(k==j)?0:dp[k+1][j];
                    int midval = (i==0?1:nums[i-1])*nums[k]*(j==len-1?1:nums[j+1]);
                    max=Math.max(max, leftval+midval+rightval);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][len-1];
    }
}
