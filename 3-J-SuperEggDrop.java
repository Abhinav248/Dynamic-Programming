// https://leetcode.com/problems/super-egg-drop/
// Hint: https://www.youtube.com/watch?v=3hcaVyX00_4

// Time Limit Exceeded !!!
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int j=0;j<=n;j++) dp[1][j]=j;
        
        for(int i=2;i<=k;i++) {
            for(int j=1;j<=n;j++) {
                if(j<i)
                    dp[i][j]=dp[i-1][j];
                else {
                    int minm=Integer.MAX_VALUE;
                    for(int e=1;e<=j;e++){
                        minm=Math.min(minm,Math.max(dp[i-1][e-1], dp[i][j-e]));
                    }
                    dp[i][j]=1+minm;
                }
            }
        }
        return dp[k][n];
    }
}
