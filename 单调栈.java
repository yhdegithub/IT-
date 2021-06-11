/**
 * 单调栈问题
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
        fun(a, n);
    }

    /**
     * 找到位置i的左右两边距离他最小小于a[i]的位置.
     * 单调递增栈，左大右小，所以选择单调递栈，两边遍历
     */
    private static void fun(int[] a, int n) {
        if (n <= 1)
            System.out.println(-1 + " " + (-1));
        int left[] = new int[n];
        left[0] = -1;
        // 使用递增栈求左边较小者的位置
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || a[stack.peek()] < a[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                    int t = stack.pop();
                    left[t] = stack.isEmpty() ? -1 : stack.peek();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }


        }
        // 栈可能非空
        while (!stack.isEmpty()) {
            int t = stack.pop();
            left[t] = stack.isEmpty() ? -1 : stack.peek();
        }
        // 右边叫小者，则从右往左遍历即可
        stack.clear();
        int right[] = new int[n];
        right[n - 1] = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty() || a[stack.peek()] < a[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                    int t = stack.pop();
                    right[t] = stack.isEmpty() ? -1 : stack.peek();
                }
                right[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
        }
        // 栈可能非空
        while (!stack.isEmpty()) {
            int t = stack.pop();
            right[t] = stack.isEmpty() ? -1 : stack.peek();
        }
        // 打印结果
        for (int i = 0; i < n; i++)
            System.out.println(left[i] + " " + right[i]);
    }


}



