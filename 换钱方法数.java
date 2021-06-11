import java.util.*;

import static java.lang.Math.abs;

// 有序旋转数组中，找到最小值
public class Main {
    static int p = 1000000007;
    //4 15
    //5 10 25 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),target =sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] =sc.nextInt();
        Arrays.sort(a);
        System.out.println(fun(a,n,target));
    }

    private static int fun(int[] a, int n, int target) {
        if (target == 0)
            return 1;
        if (n == 0 || target < a[0])
            return 0;
        // dp[i][j]  用a[0...i-1]凑合j的数目
        int dp[][] = new int[n][target + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;
        for (int j = a[0]; j <= target; j += a[0])
            dp[0][j] = 1;
        for (int i = 1; i < n; i++)
            for (int j = 1; j <= target; j++) {
                if (j - a[i] >= 0)
                    dp[i][j] = dp[i - 1][j] %p + dp[i][j - a[i]] %p;
                else
                    dp[i][j] = dp[i - 1][j]%p;
            }
        return dp[n - 1][target];
    }






}
