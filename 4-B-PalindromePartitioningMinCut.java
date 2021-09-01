// https://leetcode.com/problems/palindrome-partitioning-ii/
// Hint: https://www.youtube.com/watch?v=lDYIvtBVmgo

class Solution {
    public int minCut(String s) {
        int l=s.length();
        boolean[][] dp=new boolean[l][l];
        int[][] count_dp=new int[l][l];
        int max=0;
        String longestSubstring="";
        
        for(int d=0;d<l;d++) {
            for(int i=0, j=d; j<l; i++, j++) {
                if (d==0) dp[i][j]=true;
                else if(d==1) {
                    if(s.charAt(i)==s.charAt(j)) dp[i][j]=true;
                    else count_dp[i][j]=1;
                } 
                else if(d>=2){
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j]=true;
                        count_dp[i][j]=0;
                    }
                    else {
                        dp[i][j]=false;
                        int minm=2001;
                        for(int k=i;k<j;k++) minm=Math.min(minm, count_dp[i][k]+count_dp[k+1][j]);
                        count_dp[i][j]=minm+1;
                    }
                }
            }
        }
        
        return count_dp[0][l-1];
    }
}
