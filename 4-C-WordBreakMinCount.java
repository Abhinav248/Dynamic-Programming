// https://leetcode.com/problems/word-break/
// Hint: https://www.youtube.com/watch?v=WepWFGxiwRs


class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        int l=s.length();
        boolean[][] dp=new boolean[l][l];
        
        for(int d=0;d<l;d++) {
            for(int i=0, j=d; j<l; i++, j++) {
                String substr=s.substring(i,j+1);
                if(dict.contains(substr))
                    dp[i][j]=true;
                else {
                    for(int k=i;k<j;k++) {
                        if(dp[i][k]==true && dp[k+1][j]==true) {
                            dp[i][j]=true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][l-1];
    }
}
