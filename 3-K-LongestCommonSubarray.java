// https://leetcode.com/problems/maximum-length-of-repeated-subarray/
// HINT: https://www.youtube.com/watch?v=BysNXJHzCEs

class Solution {
    public int findLength(int[] n1, int[] n2) {
        int r=n1.length;
        int c=n2.length;
        int[][] dp= new int[r+1][c+1];
        
        int maxm=Integer.MIN_VALUE;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(n1[i-1]==n2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                maxm=Math.max(maxm, dp[i][j]);
            }
        }
     return maxm;   
    }
}
