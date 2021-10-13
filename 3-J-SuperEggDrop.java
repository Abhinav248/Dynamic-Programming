// https://leetcode.com/problems/super-egg-drop/
// Hint: https://www.youtube.com/watch?v=3hcaVyX00_4

// Time Limit Exceeded !!!
class Solution {
    public int superEggDrop(int k, int n) { // k = no. of eggs and n = no. of floors
        int[][] dp = new int[k+1][n+1];
        for(int j=0;j<=n;j++) dp[1][j]=j;
        
        for(int i=2;i<=k;i++) {
            for(int j=1;j<=n;j++) {
                if(j<i)
                    dp[i][j]=dp[i-1][j];
                else {
                    int minm=Integer.MAX_VALUE;
                    for(int e=1;e<=j;e++){
                        minm=Math.min(minm // consider previous min value if possible
                                      ,Math.max(
                                          dp[i-1][e-1], // if on dropping at floor e, egg break so left with one less eggs that is i-1 and since it broke on floor e then we have to now look floor below that i.e. e-1
                                          dp[i][j-e] // if on dropping at floor e, egg doesn't so no changes in eggs i.e. i eggs and since it didn't break on floor e then we have to now look floor above that i.e. j-e floors
                                      ));
                    }
                    dp[i][j]=1+minm; // current 1 attempt + minm
                }
            }
        }
        return dp[k][n];
    }
}
