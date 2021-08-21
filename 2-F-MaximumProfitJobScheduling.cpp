// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// https://www.youtube.com/watch?v=cr6Ip0J9izc

#include<bits/stdc++.h>
#include<algorithm>
#include<vector>

using namespace std;

class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int len=profit.size();
        vector<int> dp;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(endTime[j]>endTime[i]){
                    swap(endTime[j],endTime[i]);
                    swap(startTime[j],startTime[i]);
                    swap(profit[j],profit[i]);
                }
            }
        }
        //Minimum profit for each job is considered below.
        dp = profit;
        int maxm=dp[0];
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(startTime[i]>=endTime[j])
                    dp[i]=max(dp[i],dp[j]+profit[i]);
                maxm=max(maxm,dp[i]);
            }
        }
        return maxm;
    }
};
