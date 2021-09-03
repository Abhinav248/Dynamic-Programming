// https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
// Hint: https://www.youtube.com/watch?v=WxpIHvsu1RI

public class Solution {

    public static int OptimalStrategyGamePlan(int[] score) {
        int n=score.length;
        if(n<1) return 0;

        int[][][] dp=new int[n][n][2];

        for (int d=0;d<n;d++) {
            dp[d][d][0]=score[d];                           // player1
            dp[d][d][1]=0;                                  // player2
        }

        for (int d=1;d<n;d++) {
            dp[d-1][d][0]=Math.max(score[d-1],score[d]);    // player1
            dp[d-1][d][1]=Math.min(score[d-1],score[d]);    // player2
        }

        for (int d=2;d<n;d++) {
            for (int i=0;i<n-d;i++) {
                int j=i+d;
                int left_points=score[i]+dp[i+1][j][1];     // Choosing from left end: score[i]
                int right_points=score[j]+dp[i][j-1][1];    // Choosing from right end: score[j]
                if (left_points>right_points) {
                    dp[i][j][0]=left_points;
                    dp[i][j][1]=dp[i+1][j][0];
                } else {
                    dp[i][j][0]=right_points;
                    dp[i][j][1]=dp[i][j-1][0];
                }
            }
        }
        return dp[0][n-1][0];
    }

    public static void main(String[] args) {
        int[] point1 ={8, 15, 3, 7};
        int[] point2={2, 2, 2, 2};
        int[] point3={20, 30, 2, 2, 2, 10};
        int[] point4={3, 1, 5, 8};
        int[] point5={5};
        int[] point6={};
        System.out.println(OptimalStrategyGamePlan(point1));
        System.out.println(OptimalStrategyGamePlan(point2));
        System.out.println(OptimalStrategyGamePlan(point3));
        System.out.println(OptimalStrategyGamePlan(point4));
        System.out.println(OptimalStrategyGamePlan(point5));
        System.out.println(OptimalStrategyGamePlan(point6));
    }
}
