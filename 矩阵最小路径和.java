// 矩阵最小路径和，典型的动态

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
            return 0;
        int dp[][] = new int[m][n];
        dp[0][0] = a[0][0];
         // 初始化第一行，第一竖列
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1] + a[0][j];
        }
        for(int i=1;i<m;i++){
            dp[i][0] =dp[i-1][0] +a[i][0];
        }
        // 开始动态规划，dp[i][j] = Math.min(dp[i-1][j] + dp[i]j-1]) + a[i][j];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[i][j] = Math.min(dp[i-1][j] ,dp[i][j-1]) + a[i][j];
         return dp[m-1][n-1];

    }


}