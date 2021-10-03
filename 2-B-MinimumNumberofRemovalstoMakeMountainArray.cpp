// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
// Hint: https://www.youtube.com/watch?v=TWHytKnOPaQ OR https://www.youtube.com/watch?v=uVGrbtm69Vo

#include<vector>
#include<algorithm>

class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        int len=nums.size();
        
        vector<int> dp_inc;
        dp_inc.assign(len, 1);
        vector<int> dp_dec;
        dp_dec.assign(len, 1);
        
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp_inc[i]=max(dp_inc[i], dp_inc[j]+1);
                }
            }
        }

        for(int i=len-1;i>=0;i--){
            for(int j=len-1;j>i;j--){
                if(nums[j]<nums[i]){
                    dp_dec[i]=max(dp_dec[i], dp_dec[j]+1);
                }
            }
        }
        
        int res=0;
        for(int i=0;i<len;i++) {
            if(dp_inc[i]>1 && dp_dec[i]>1)
                res=max(res, (dp_inc[i]+dp_dec[i]-1));
        }
        
        return len-res;
    }
};

/* Similar Problems:
1. Longest Bitonic Subsequence
*/

