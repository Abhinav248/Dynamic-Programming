// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
// https://www.youtube.com/watch?v=9mod_xRB-O0 (Similar problem)

class Solution {
    public int maxHeight(int[][] c) {
        for(int[] cu : c){
            Arrays.sort(cu);
        }
        Arrays.sort(c, (a, b) -> {
            int e = Integer.compare(a[2], b[2]);
            if(e == 0){ //if largest elements are equal, check other two elements
                int l = Integer.compare(a[0], b[0]);
                if(l == 0){
                    return Integer.compare(a[1], b[1]);
                }
                return l;
            }
            return e;
        });

        //here onwards very similar to LIS
        int[] dp = new int[c.length]; 
        int ans = 0;
        for(int i = 0; i < c.length; i++){
            dp[i] = c[i][2]; //this cuboid's height is the max height it can achieve at this point
            for(int j = 0; j < i; j++){
                if(c[j][0] <= c[i][0] && c[j][1] <= c[i][1]){
                    dp[i] = Math.max(dp[i], c[i][2] + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
