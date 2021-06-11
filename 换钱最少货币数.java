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
        System.out.println(fun(a,n,target));
    }

    private static int fun(int[] a, int n, int target) {
        if (target <= 0)
            return 0;
        if (a == null || n <= 0)
            return -1;
        //不可能用到target+1张找零方式吧
        int dp[] = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= target)
                dp[a[i]] = 1;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++)
                if (i - a[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1)  %p;
        }
        if(dp[target] >= target+1)
            return -1;
        return dp[target];
    }





}
