// https://leetcode.com/problems/longest-valid-parentheses/

class Solution {
    public int longestValidParentheses(String s) {
        int l=s.length();
        int[] v=new int[l];
        //v[0]=0;
        for(int i=1;i<l;i++){
            if(s.charAt(i)=='(')
                v[i]=0;
            else if(s.charAt(i-1)=='(') {
                v[i]=2;
                if(i>=2){
                    v[i]+=v[i-2];
                }
            }
            else if(s.charAt(i-1)==')' 
                    && (i-v[i-1]-1 >= 0) && s.charAt(i-v[i-1]-1)=='('){
                v[i]=v[i-1] + 2;
                if((i-v[i-1]-2) >= 0){
                    v[i]+=v[i-v[i-1]-2];
                }
            }
        }
        int max=0;
        for(int i=0;i<l;i++){
            if(v[i]>max)
                max=v[i];
        }
        return max;
    }
}

