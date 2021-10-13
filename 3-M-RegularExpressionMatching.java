// https://leetcode.com/problems/regular-expression-matching/
// Hint: https://www.youtube.com/watch?v=l3hda49XcDE

class Solution {
    public boolean isMatch(String s, String p) {
        int r=s.length();
        int c=p.length();
        boolean[][] dp= new boolean[r+1][c+1];
        
        dp[0][0]=true; // default: dp[0][i]=false, dp[i][0]=false
        
        for(int j=2;j<=c;j++)
            if(p.charAt(j-1)=='*') dp[0][j]=dp[0][j-2];
        
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                // Either p[j-1]==s[i-1] or or p[j-1]=='.' which can be taken with s[i-1]
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if (p.charAt(j-1)=='*') {
                    if(dp[i][j-2]) // Check if string.substr(0,i) matches with with pattern.substr(0,j-2)
                        dp[i][j]=dp[i][j-2]; // as pattern.substr(j-1,j-2) Ex. 'a*' can be considerd as zero occurance of 'a'
                    else if(p.charAt(j-1-1)==s.charAt(i-1) || p.charAt(j-1-1)=='.')
                        dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[r][c]; 
        
    }
}
