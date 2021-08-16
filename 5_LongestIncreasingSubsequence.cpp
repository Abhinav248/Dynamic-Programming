// https://leetcode.com/problems/longest-increasing-subsequence/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int len=nums.size();
        vector<int> dp;
        //Each element is itself a subsequence
        dp.assign(len, 1); //similar to below
        /*dp.resize(len);
        for(int i=0;i<len;i++)
            dp[i]=1;*/
        int maxm=dp[0]; //For Kadane's Algorithm
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=max(dp[i], dp[j]+1);
                    maxm=max(maxm, dp[i]); //Kadane's Algorithm
                }
            }
        }
        //Not required after using Kadane's Algorithm
        /*int max=dp[0];
        for(int i=1;i<len;i++){
            if(dp[i]>max)
                max=dp[i];
        }*/
        return maxm;
    }
};
