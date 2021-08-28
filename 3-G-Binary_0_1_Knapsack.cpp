// https://www.interviewbit.com/problems/0-1-knapsack/
// https://www.youtube.com/watch?v=8LusJS5-AGo

#include<vector>
#include<algorithm>
using namespace std;

int Binary_0_1_Knapsack(vector<int> &A, vector<int> &B, int C) {
    
    int r=A.size();
    int dp[r][C+1];

    for(int i=0;i<r;i++)
        for(int j=0;j<=C;j++)
            dp[i][j]=0;

    vector< pair <int,int> > vect;

    for (int i=0; i<r; i++)
        vect.push_back( make_pair(B[i],A[i]) );

    sort(vect.begin(), vect.end());
    
    for(int i=0;i<r;i++)
        dp[i][0]=0;

    for(int j=1;j<=C;j++) {
        if(j<vect[0].first==0)
            dp[0][j]=vect[0].second;
    }

    for(int i=1;i<r;i++) {
        for(int j=1;j<=C;j++) {
            if(j<vect[i].first)
                dp[i][j]=dp[i-1][j];
            else
                dp[i][j]=max(
                        vect[i].second + dp[i-1][j-vect[i].first],   // include
                        dp[i-1][j]                                   // exclude
                        );
        }
    }

    return dp[r-1][C];
}

int main() {
    vector<int> value = {359, 963, 465, 706, 146, 282, 828, 962, 492} ;
    vector<int> veight = {96, 43, 28, 37, 92, 5, 3, 54, 93};
    cout<<endl<<Binary_0_1_Knapsack(value, weight, 383);
    return 0;
}
