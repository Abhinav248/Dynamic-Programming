// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// Hint: https://www.youtube.com/watch?v=oDhu5uGq_ic

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n<1) return 0;
        int[][] dp = new int[k+1][n];
        for(int i=1;i<=k;i++) {
            for(int j=1;j<n;j++) {
                int max=0;
                for (int m=0;m<j;m++) {
                    max=Math.max(max, prices[j]-prices[m]+dp[i-1][m]);
                }
                dp[i][j]=Math.max(dp[i][j-1], max);
            }
        }
        return dp[k][n-1];
    }
}
