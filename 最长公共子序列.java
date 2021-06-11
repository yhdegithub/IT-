import java.util.*;

import static java.lang.Math.abs;

// 最长公共子序列
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
        System.out.println(fun(a, b));
    }

    /**
     * dp[i][j]只可能来自三种情况
     * 1） a[i] == b[j]   dp[i-1][j-1] +1;
     * 2) a[i] != b[j]   取dp[i-1][j]、dp[i][j-1]、dp[i-1][j-1]三者的最大值
     */
    private static int[][] getDp(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return new int[][]{};
        }
        char ac[] = a.toCharArray();
        char bc[] = b.toCharArray();
        int m = ac.length, n = bc.length;
        int dp[][] = new int[m][n];
        //处理第一行和第一列
        int i = 0, j = 0;
        while (j < n) {
            if (ac[0] == bc[j]) {
                while (j < n) {
                    dp[0][j] = 1;
                    j++;
                }
            } else
                j++;
        }
        while (i < m) {
            if (ac[i] == bc[0]) {
                while (i < m) {
                    dp[i][0] = 1;
                    i++;
                }
            } else
                i++;
        }
        // 开始动态规划
        for (i = 1; i < m; i++)
            for (j = 1; j < n; j++) {
                if (ac[i] == bc[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        return dp;
    }

    //根据dp[][]和两个字符串情况，从dp[][]右下角开始斜上走
    public static String fun(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return "-1";
        }
        int m = a.length() - 1, n = b.length() - 1;
        int dp[][] = getDp(a, b);
        StringBuilder sb = new StringBuilder();
        char ac[] = a.toCharArray();
        char bc[] = b.toCharArray();
        int index = dp[m][n] - 1;
        if (index < 0)
            return "-1";
        while (index>=0) {
            if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else {
                sb.append(ac[m]);
                m--;
                n--;
            }
                index--;

        }
        return sb.reverse().toString();
    }

}
