// https://leetcode.com/problems/coin-change-2/
// https://www.youtube.com/watch?v=_fgjrs570YE

class Solution {
    public int change(int amount, int[] coins) {
        int len=coins.length;
        int[][] dp=new int[len][amount+1];

        //For amount=0, i.e. 0th column
        for (int i=0;i<len;i++)
            dp[i][0]= 1;

        //For coins[0], i.e. 0th row
        for (int j=1;j<amount+1;j++)
            dp[0][j]=(j%coins[0]==0)?1:0;

        for(int i=1;i<len;i++) {
            for(int j=1;j<amount+1;j++) {
                if(j<coins[i])
                    dp[i][j]=dp[i-1][j];
                else {
                    int inc = dp[i][j-coins[i]];
                    int exc = dp[i-1][j];
                    dp[i][j]=inc+exc;
                }
            }
        }
        
        return dp[len-1][amount];
    }
}
