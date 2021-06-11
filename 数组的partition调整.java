/**
 * 数组的partition调整
 */

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        fun(a, n);
        for(Integer K:a)
            System.out.println(K + " ");
    }

    /**
     * 使用一个量k, 代表[0..k]已经有序且不重复。 然后遍历数组，只要遇到一个数字和a[k]不同
     * 就交换a[k]和a[i], 并且k++
     *
     * @param a
     * @param n
     */
    private static void fun(int[] a, int n) {
        if (n <= 1)
            return;
        int k = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[k]) {
                k++;
                swap(a, i, k);
            } else
                continue;
        }
    }

    private static void swap(int[] a, int i, int k) {
        int t = a[i];
        a[i] = a[k];
        a[k] = t;
    }


}
