// https://leetcode.com/problems/longest-arithmetic-subsequence/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int len=nums.length;
        if(len<=2)
            return len;
        HashMap<Integer,Integer>dp[]=new HashMap[len];
        dp[0]=new HashMap<Integer,Integer>();
        int maxLen=0;
        for(int i=1;i<len;i++) {
            dp[i]=new HashMap<Integer,Integer>();
            for(int j=0;j<i;j++) {
                int common_diff = nums[i]-nums[j];
                if(dp[j].containsKey(common_diff)){
                    dp[i].put(common_diff,1+dp[j].get(common_diff));
                } else {
                    dp[i].put(common_diff,2);
                }
                maxLen=Math.max(maxLen,dp[i].get(common_diff));
            }
        }
        return maxLen;
    }
}
