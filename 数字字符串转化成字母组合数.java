import java.util.*;

public class Main {
    static int p = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toString().toCharArray();
        int n = ch.length;
        int[] arr = new int[n];
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ch[i] - '0';
        }
        System.out.println(fun(a, n));
    }

    private static int fun(int[] a, int n) {
        if (n == 0 || a[0] == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2) {
            return getNumTwo(a, 2);
        }
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = getNumTwo(a, 2);
        for (int i = 2; i < n; i++) {
            if (a[i] == 0) {
                if (a[i - 1] != 1 && a[i - 1] != 2)
                    return 0;
                else
                    dp[i] = dp[i - 2]%p;

            } else if (a[i] >= 1 && a[i] <= 6) {

                if (a[i - 1] >= 3)
                    dp[i] = dp[i - 1]%p;
                else if (a[i - 1] == 0)
                    dp[i] = dp[i - 2]%p;
                else
                    dp[i] = (dp[i - 2] + dp[i - 1])%p;


            } else {

                if (a[i - 1] >= 2)
                    dp[i] = dp[i - 1]%p;
                else if (a[i - 1] == 0)
                    dp[i] = dp[i - 2]%p;
                else
                    dp[i] = (dp[i - 2] + dp[i - 1])%p;
            }

        }
        return dp[n - 1];
    }

    public static int getNumTwo(int a[], int n) {
        int cur = a[0] * 10 + a[1];
        if ((cur <= 19 && cur >= 11) || (cur <= 26 && cur >= 21))
            return 2;
        if (cur == 20 || cur == 10)
            return 1;
        if (cur % 10 == 0)
            return 0;
        if (cur >= 27)
            return 1;
        return -1;
    }
}
