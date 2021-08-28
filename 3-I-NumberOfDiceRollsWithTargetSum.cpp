// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
// Hint: https://www.youtube.com/watch?v=BeyJboRnKDI

class Solution {
    private static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int d, int f, int target) {
        
        int[][] dp = new int[d+1][target + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                // try each face
                for (int k = 1; k <= f; k++) {
                    if (j - k < 0) continue;
                    dp[i][j] = (dp[i][j] + dp[i-1][j - k]) % MOD;
                }
            }
        }
        return dp[d][target];
    }
}
