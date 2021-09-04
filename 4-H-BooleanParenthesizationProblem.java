// https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/
// Hint: https://www.youtube.com/watch?v=JbRsM2X2_pg

public class Solution {

    public static int BooleanParenthesization(String operands, String operators) {

        int n1=operands.length();
        int n2=operators.length();

        if(n1!=n2+1) return 0;               // no. of operands (n1) must be 1 greater than no. of operators (n2)

        int[][] true_dp=new int[n1][n1];     // dp[i][j] -> maximum possible ways to get the true result from index i to j
        int[][] false_dp=new int[n1][n1];    // dp[i][j] -> maximum possible ways to get the false result from index i to j

        for (int d=0;d<n1;d++) {
            for (int i = 0; i < n1 - d; i++) {
                int j = i + d;

                if (d == 0) {
                    if (operands.charAt(i) == 'T') {
                        true_dp[i][j] = 1;
                        false_dp[i][j] = 0;
                    } else {
                        true_dp[i][j] = 0;
                        false_dp[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        int left_true_count = true_dp[i][k];
                        int right_true_count = true_dp[k + 1][j];
                        int left_false_count = false_dp[i][k];
                        int right_false_count = false_dp[k + 1][j];
                        char operator = operators.charAt(k);

                        if (operator == '&') {
                            true_dp[i][j] += left_true_count * right_true_count;      // T & T
                            false_dp[i][j] += left_false_count * right_true_count +   // (F & T) +
                                              left_true_count * right_false_count +   // (T & F) +
                                              left_false_count * right_false_count;   // (F & F) +
                        } else if (operator == '|') {
                            true_dp[i][j] += left_true_count * right_true_count +     // (T | T) +
                                             left_true_count * right_false_count +    // (T | F) +
                                             left_false_count * right_true_count;     // (F | T)
                            false_dp[i][j] += left_false_count * right_false_count;   // (F | F)
                        } else if (operator == '^') {
                            true_dp[i][j] += left_true_count * right_false_count +    // (T ^ F) +
                                             left_false_count * right_true_count;     // (F ^ T)
                            false_dp[i][j] += left_true_count * right_true_count +    // (T ^ T) +
                                              left_false_count * right_false_count;   // (F ^ F)
                        }
                    }
                }
            }
        }
        return true_dp[0][n1-1];
    }

    public static void main(String[] args) {
        String s1="TFT";
        String o1="^&";
        String s2="TFF";
        String o2="^|";
        String s3="TTFT";
        String o3="|&^";
        String s4="TTFT";
        String o4="";
        String s5="T";
        String o5="";
        String s6="F";
        String o6="";
        String s7="";
        String o7="";
        System.out.println(BooleanParenthesization(s1,o1));
        System.out.println(BooleanParenthesization(s2,o2));
        System.out.println(BooleanParenthesization(s3,o3));
        System.out.println(BooleanParenthesization(s4,o4));
        System.out.println(BooleanParenthesization(s5,o5));
        System.out.println(BooleanParenthesization(s6,o6));
        System.out.println(BooleanParenthesization(s7,o7));
    }
}
