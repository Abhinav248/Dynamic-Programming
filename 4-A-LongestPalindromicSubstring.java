// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        
        int l=s.length();
        boolean[][] dp=new boolean[l][l];
        int max=0;
        String longestSubstring="";
        
        for(int d=0;d<l;d++){
            for(int i=0, j=d; j<l; i++, j++){
                if(
                  (d==0) ||                                                     // length=1 or (i==j) i.e diagonal
                  (d==1 && s.charAt(i)==s.charAt(j)) ||                         // length=2 or j==i+1
                  (d>=2 && dp[i+1][j-1] && s.charAt(i)==s.charAt(j))            // length>2 or j>=i+2
                  ) {
                    dp[i][j]=true;
                    if(j-i+1>max){
                        max=j-i+1;
                        longestSubstring=s.substring(i,j+1);
                    }
                    //System.out.println(s.substring(i,j+1));                     // Prints all palindromic substring
                }
            }
        }
        
        return longestSubstring;
    }
}

/*class Solution {
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
*/
