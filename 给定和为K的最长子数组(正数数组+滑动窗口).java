/**
 * 5 3
 * 1 2 1 1 1
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // 实现函数
        System.out.println(fun(a, n, k));

    }

    private static int fun(int[] a, int n, int k) {
        if (n == 0)
            return 0;
        // 双指针操作
        int i = 0, j = 0;
        int max = 0;
        int sum = a[0];
        while (j < n) {
            if (sum == k) {
                 max = Math.max(j-i+1,max);
                 sum -= a[i];
                 i++;
            } else if (sum > k) {
               sum -=a[i];
               i++;
            } else {
                j++;
                if(j==n)
                    break;
                sum += a[j];
            }

        }
        return max;
    }


}



