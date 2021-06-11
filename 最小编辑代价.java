import java.util.*;

import static java.lang.Math.abs;

// 最小编辑代价
public class Main {
    static int p = 1000000007;

    //4 15
    //5 10 25 1
    static int[] cost = new int[3];
    static int ic;
    static int dc;
    static int rc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine().toString();
        String b = sc.nextLine().toString();
        ic = sc.nextInt();
        dc = sc.nextInt();
        rc = sc.nextInt();
        System.out.println(fun(a, b));
    }

    /**
     * 明显的动态规划， dp[i][j] 代表a[0...i-1]变成b[0...j-1]最小的代价
     */
    private static int fun(String a, String b) {
        if (a.equals(b))
            return 0;
        int m = a.length(), n = b.length();
        int dp[][] = new int[m + 1][n + 1];
        //修改第1行和第1列
        for (int i = 1; i <= m; i++)
            dp[i][0] = i * dc;
        for (int j = 1; j <= n; j++)
            dp[0][j] = ic * j;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int minCost = Math.min(dp[i - 1][j - 1] + rc, dp[i][j - 1] + ic);
                    minCost = Math.min(minCost, dp[i-1][j] +dc);
                    dp[i][j] = minCost;
                }

            }
        return dp[m][n];
    }


}
