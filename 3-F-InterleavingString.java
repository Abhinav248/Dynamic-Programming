// https://leetcode.com/problems/interleaving-string/
// https://www.youtube.com/watch?v=ih2OZ9-M3OM

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        dp[0][0] = true;
        
        for(int i = 1; i <= s1.length(); i++) 
            dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        
        for(int j = 1; j <= s2.length(); j++) 
            dp[0][j] = dp[0][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1);
        
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                char x = s1.charAt(i - 1);
                char y = s2.charAt(j - 1);
                char z = s3.charAt(i + j - 1);
                if(x == z && y == z) dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if(y == z) dp[i][j] = dp[i][j - 1];
                else if(x == z) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = false;
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}
