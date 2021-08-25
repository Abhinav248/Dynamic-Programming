// https://www.youtube.com/watch?v=IRwVmTmN6go

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int RodCuttingMaximumProfit (vector<int> profit, int len) {
    int row=profit.size();
    int dp[row][len+1];

    for(int i=0;i<row;i++)
        for(int j=0;j<=len;j++)
            dp[i][j]=0;

    for (int i=0;i<row ;i++) dp[i][0]=0;
    for (int j=1;j<=len;j++) dp[0][j]=j*profit[0];

    for(int i=1;i<row;i++) {
        for(int j=1;j<=len;j++){
            if(i>=j){
                dp[i][j]=dp[i-1][j];
            } else {
                int inc=profit[i]+dp[i][j-i-1];
                int exc=dp[i-1][j];
                dp[i][j]=max(inc,exc);
            }
        }
    }
    return dp[row-1][len];
}

int main() {
    vector<int> profit1 = {2,5,7,8};
    vector<int> profit2 = {1,5,8,9,10,17,17,20};
    cout<<RodCuttingMaximumProfit(profit1, 9);
    return 0;
}
