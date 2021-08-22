// https://leetcode.com/problems/coin-change/
// https://www.youtube.com/watch?v=Y0ZqKpToTic

class Solution {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int[][] dp=new int[len][amount+1];

        //For amount=0, i.e. 0th column
        for (int i=0;i<len;i++)
            dp[i][0]= 0;

        //For coins[0], i.e. 0th row
        for (int j=1;j<amount+1;j++)
            dp[0][j]=(j%coins[0]==0)?(j/coins[0]):-1;

        for(int i=1;i<len;i++) {
            for(int j=0;j<amount+1;j++) {
                if(j<coins[i])
                    dp[i][j]=dp[i-1][j];
                else {
                    int inc = dp[i][j-coins[i]];
                    int exc = dp[i-1][j];
                    if (inc==-1 && exc==-1)
                        dp[i][j]=-1;
                    else if(inc==-1)
                        dp[i][j]=exc;
                    else if(exc==-1)
                        dp[i][j]=inc+1;
                    else
                        dp[i][j]=Math.min(inc+1, exc);
                }
            }
        }
        
        return dp[len-1][amount];
    }
}
