// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        int max=0;
        String res="";
        
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(
                    (j==i) ||                                                    // length=1 i.e diagonal
                    (i-j<=2 && s.charAt(j)==s.charAt(i)) ||                      // length=2
                    (i-j>2 && dp[j+1][i-1] && s.charAt(j)==s.charAt(i))          // length>2
                    ){
                    dp[j][i]=true;
                    if(max<i-j+1){
                        max=i-j+1;
                        res=s.substring(j,i+1);
                    }
                }                
            }
        }
        System.out.println(max);
        return res;
    }
}
