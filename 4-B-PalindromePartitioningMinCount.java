// https://leetcode.com/problems/palindrome-partitioning-ii/
// Hint: https://www.youtube.com/watch?v=lDYIvtBVmgo

class Solution {
    public int minCut(String s) {
        int l=s.length();
        boolean[][] dp=new boolean[l][l];
        int[][] count_dp=new int[l][l];
        
        for(int d=0;d<l;d++) {
            for(int i=0, j=d; j<l; i++, j++) {
                if (d==0) {                                                               // length=1 or (i==j) i.e diagonal
                    dp[i][j]=true;
                }
                else if(d==1) {                                                           // length=2 or j==i+1
                    if(s.charAt(i)==s.charAt(j)) dp[i][j]=true;
                    else count_dp[i][j]=1;
                } 
                else if(d>=2){                                                            // length>2 or j>=i+2
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
                        dp[i][j]=true;
                        count_dp[i][j]=0;
                    }
                    else {
                        int minm=2001;
                        for(int k=i;k<j;k++) 
                            minm=Math.min(minm, count_dp[i][k]+count_dp[k+1][j]);
                        dp[i][j]=false;
                        count_dp[i][j]=minm+1;
                    }
                }
            }
        }
        
        return count_dp[0][l-1];
    }
}
