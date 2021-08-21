// https://leetcode.com/problems/jump-game-ii/
// https://www.youtube.com/watch?v=cETfFsSTGJI

#include<iostream>
#include<vector>
#include<algorithm>

class Solution {
public:
    int jump(vector<int>& nums) {
        int len=nums.size();
        vector<int> jump_dp;
        jump_dp.assign(len, INT_MAX);
        jump_dp[0]=0;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]>=i-j)
                    jump_dp[i]=min(jump_dp[i], jump_dp[j]+1);
            }
        }
        return jump_dp[len-1];
    }
};