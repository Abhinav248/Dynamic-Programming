// https://leetcode.com/problems/edit-distance/
// https://www.youtube.com/watch?v=We3YDTzNXEk

class Solution {
    public int minDistance(String w1, String w2) {
        
        int l1=w1.length();
        int l2=w2.length();
        int[][] dp = new int[l2+1][l1+1];
        
        for(int i=0;i<=l2;i++) dp[i][0]=i;
        for(int j=0;j<=l1;j++) dp[0][j]=j;
        
        for(int i=1;i<=l2;i++){
            for(int j=1;j<=l1;j++){
                if(w2.charAt(i-1)==w1.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(Math.min(
                        dp[i][j-1] ,   // Insert
                        dp[i-1][j]),   // Remove
                        dp[i-1][j-1])  // Replace
                        +1;
            }
        }
      
        return dp[l2][l1];
    }
}
