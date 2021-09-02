// https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
// Hint: https://www.youtube.com/watch?v=prx1psByp7U&list=RDCMUCZCFT11CWBi3MHNlGf019nw&start_radio=1&rv=prx1psByp7U&t=0
// Hint: https://www.youtube.com/watch?v=eKkXU3uu2zk&list=RDCMUCZCFT11CWBi3MHNlGf019nw&index=4

public class Solution {

    public static int MatrixChainMultiplicationMinCost(int[] cost) {
        int len=cost.length;
        if(len<2) return 0;
        int[][] cost_dp=new int[len][len];
        for(int d=1;d<len-1;d++) {
            for(int i=1;i<len-d;i++) {
                int j=i+d, min=Integer.MAX_VALUE;
                // We iterate through each possible combination of evaluation via i<=k<j and get the minm value of cost to cost_dp[i][j] 
                for(int k=i;k<j;k++){                        // Considering the combination: A1.(A2.A3), below:
                    int temp_cost=cost_dp[i][k]   +          // Cost of not multiplying A1 = cost_dp[1][1] = 0
                                  cost_dp[k+1][j] +          // Cost of multiplying A2.A3 = cost_dp[2][3] = 4*6*2 = 48
                                  cost[i-1]*cost[k]*cost[j]; // Cost of multiplying A1.X where X=A2.A3 = cost[0]*cost[1]*cost[3] = 5*4*2 = 40
                    min=Math.min(min, temp_cost);
                }
                cost_dp[i][j]=min;
            }
        }
        return cost_dp[1][len-1];
    }

    public static void main(String[] args) {
        int[] cost1={5, 4, 6, 2, 7};
        int[] cost2={40, 20, 30, 10, 30};
        int[] cost3={10, 20, 30, 40, 30};
        int[] cost4={10, 20, 30};
        int[] cost5={5};
        int[] cost6={};
        System.out.println(MatrixChainMultiplicationMinCost(cost1));
        System.out.println(MatrixChainMultiplicationMinCost(cost2));
        System.out.println(MatrixChainMultiplicationMinCost(cost3));
        System.out.println(MatrixChainMultiplicationMinCost(cost4));
        System.out.println(MatrixChainMultiplicationMinCost(cost5));
        System.out.println(MatrixChainMultiplicationMinCost(cost6));
    }
}
