// https://www.youtube.com/watch?v=99ssGWhLPUE

#include<iostream>
#include<vector>
#include<algorithm>
#include<stack>

using namespace std;

int main() {
    vector <int> nums = {1, 101, 10, 2, 3, 100,4};
    int len=nums.size();
    vector<int> dp;
    vector<int> index;
    int i, j;
    for(i=0;i<len;i++) {
        dp.push_back(nums[i]);
        index.push_back(i);
    }
    for(i=1;i<len;i++){
        for(j=0;j<i;j++){
            if(nums[j]<nums[i]){
                if(dp[j]+nums[i]>dp[i]) {
                    dp[i]=dp[j]+nums[i];
                    index[i]=j;
                }
            }
        }
    }
    /*for(int i:dp)
    cout<<i<<" ";
    cout<<endl;
    for(int i:index)
    cout<<i<<" ";
    cout<<endl;*/
    int max=dp[0];
    int maxIndex = 0;
    for(i=1;i<len;i++){
        if(dp[i]>max){
            max=dp[i];
            maxIndex=i;
        }
    }
    cout<<"Maximum Sum Increasing Subsequence: "<<max<<endl;
    cout<<"Elements considered are: ";
    stack<int> subsequencepath;
    while(true){
        subsequencepath.push(maxIndex);
        if(maxIndex==index[maxIndex])
            break;
        maxIndex=index[maxIndex];
    }
    while (!subsequencepath.empty()) {
        cout<<nums[subsequencepath.top()]<<" ";
        subsequencepath.pop();
    }
    return 0;
}

/* Similar Problems:
1. Maximum Sum Decreasing Subsequence
2. Maximum Sum Decreasing Subsequence Elements
3. Minimum Sum Count Increasing Subsequence
4. Minimum Sum Increasing Subsequence Elements
5. Minimum Sum Count Decreasing Subsequence
6. Minimum Sum Decreasing Subsequence Elements
*/

