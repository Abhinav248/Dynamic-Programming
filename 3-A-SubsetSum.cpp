// https://www.youtube.com/watch?v=s6FhG--P7z0

#include <iostream>
#include "vector"
using namespace std;

bool findSubsetSum (vector<int> nums, int sum) {
    int len=nums.size();
    bool dp[len+1][sum+1];
    
    //For sum=0, i.e. 0th column
    for (int i=0;i<len+1;i++)
        dp[i][0]= true;
        
    //For nums=0, i.e. 0th row
    for (int i=1;i<sum+1;i++)
        dp[0][i]= false;
    
    //dp[0][0]=true; from above.
        
    for(int i=1;i<len+1;i++) {
        for(int j=1;j<sum+1;j++){
            if(j<nums[i])
                dp[i][j]=dp[i-1][j];
            else
                dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
        }
    }
    
    return dp[len][sum];
}

int main() {
    vector<int> nums = {2,3,7,8,9};
    if(findSubsetSum(nums, 11))
        cout<<"Subset Sum Exists"<<endl;
    else
        cout<<"Subset Sum Doesn't Exist"<<endl;
    return 0;
}


