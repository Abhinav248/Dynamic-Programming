// https://leetcode.com/problems/longest-palindromic-subsequence/
// Hint: https://www.youtube.com/watch?v=_nCsPn7_OgI

class Solution {
    public int longestPalindromeSubseq(String s) {
        int l=s.length();
        int[][] dp=new int[l][l];
        
        for(int d=0;d<l;d++) {
            for(int i=0, j=d; j<l; i++, j++) {
                if(d==0) 
                    dp[i][j]=1;
                else if(d==1)
                    dp[i][j]=(s.charAt(i)==s.charAt(j))?2:1;
                else {
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=2+dp[i+1][j-1];
                    else {
                        dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[0][l-1];
    }
}
