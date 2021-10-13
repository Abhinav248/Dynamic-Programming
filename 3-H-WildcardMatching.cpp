// https://leetcode.com/problems/wildcard-matching/
// Hint: https://www.youtube.com/watch?v=3ZDZ-N0EPV0

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        int r=s.size();
        int c=p.size();
        bool dp[r+1][c+1];

        for(int i=0;i<=r;i++)
            for(int j=0;j<=c;j++)
                dp[i][j]= false;

        dp[0][0]= true;
        for(int j=1;j<=c;j++)
            if(p.at(j-1)=='*')
                dp[0][j]=dp[0][j-1];
        
        for(int i=1;i<=r;i++) {
            for(int j=0;j<=c;j++) {
                if(j==0)
                    dp[i][j]= false;
                else{
                    // Either each to each character matching in pattern and string or 
                    // pattern has '?' which can go with anyone character in string
                    if(s.at(i-1)==p.at(j-1) || p.at(j-1)=='?')
                        dp[i][j] = dp[i-1][j-1];
                    else if(p.at(j-1)=='*')
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[r][c];
    }
};
