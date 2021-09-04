// Related Problem in C++:
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Approach 1: Time Limit Succeeded
int maxProfit(vector<int>& prices) {
    int n=prices.size();
    int maxm=0;
    for(int i=0;i<n-1;i++) {
        for(int j=i+1;j<n;j++)
            maxm=max(maxm,prices[j]-prices[i]);
    }
    return maxm;
}

// Approach 2: All testcase passed
int maxProfit(vector<int>& prices) {
    int len = prices.size();
    int global_maxProfit = 0;
    int minPrice_tillNow = prices[0];
    for (int i = 1; i < len; i++) {
        int currentProfit = prices[i] - minPrice_tillNow;
        global_maxProfit = max(global_maxProfit, currentProfit);
        minPrice_tillNow = min(minPrice_tillNow, prices[i]);
    }
    return global_maxProfit;
}



// Actual Problem in Java:
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
