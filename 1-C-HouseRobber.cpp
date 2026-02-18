// https://leetcode.com/problems/house-robber/
// https://www.youtube.com/watch?v=UtGtF6nc35g

class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        int inclusive = 0;
        int exclusive = 0;
        for(int i=0; i<l; i++) {
            int temp = inclusive;
            inclusive = Math.max(nums[i]+exclusive, inclusive);
            exclusive = temp;
        }
        return Math.max(inclusive, exclusive);
    }
}

/*
#include<algorithm>
#include<vector>

using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> dp;
        int len=nums.size();
        dp.resize(len);
        dp[0]=nums[0];
        for(int i=1;i<len;i++){
            if(i==1)
                dp[i]=max(nums[0], nums[1]);
            else
                dp[i]=max(max(nums[i]+dp[i-2],dp[i-1]),nums[i]);
        }
        int maxm=dp[0];
        for(int i=1;i<len;i++)
            maxm=max(dp[i],maxm);
        return maxm;
    }
};
*/

/*
// Java Solution
class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i=1;i<len;i++){
            if(i==1)
                dp[i]=Math.max(nums[0],nums[1]);
            else
                dp[i]=Math.max(Math.max(nums[i]+dp[i-2],dp[i-1]),nums[i]);
        }
        int maxm=dp[0];
        for(int i=1;i<len;i++)
            maxm=Math.max(dp[i], maxm);
        return maxm;
    }
}
*/

/* Similar Problems:
1. Maximum Non-Adjacent Sum Elements
2. Minimum Non-Adjacent Sum Length
3. Minimum Non-Adjacent Sum Elements
*/

