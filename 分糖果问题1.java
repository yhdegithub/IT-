/**
 * 分糖果问题
 */

import java.io.*;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.nio.Buffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(fun(a, n));
    }

    /**
     * 左右遍历两次数组，较大值为前者糖果加1
     */
    private static long fun(int[] a, int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int res[] = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++)
            if (a[i] > a[i - 1])
                res[i] = res[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
			// 注意这里的判定条件
            if (a[i] > a[i + 1] && res[i] <= res[i+1])
                res[i] = res[i + 1] + 1;
          // 计算结果
        int sum=0;
        for(Integer I : res)
            sum += I;
        return sum;

    }


}
