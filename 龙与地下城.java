// 龙与地下城游戏。 就是一个矩阵最小和 ，只不过保证最后一个节点为1，然后往左边或者上边递推就是了

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
        System.out.println(fun(a, m, n));
    }

    private static int fun(int[][] a, int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        int dp[][] = new int[m][n];
        // dp[i][j]代表到从a[i][j]到达a[m-1][n-1]的最小生命值
        // 先更新最后一行，最后一列
        dp[m - 1][n - 1] = a[m - 1][n - 1] >= 0 ? 1 : -a[m - 1][n - 1] + 1;
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = dp[m - 1][j + 1] - a[m - 1][j];
            if (dp[m - 1][j] < 1)
                dp[m - 1][j] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] - a[i][n - 1];
            if (dp[i][n - 1] < 1)
                dp[i][n - 1] = 1;
        }
        // 更新值
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - a[i][j];
                if (dp[i][j] < 1)
                    dp[i][j] = 1;
            }
        return dp[0][0];
    }



}


