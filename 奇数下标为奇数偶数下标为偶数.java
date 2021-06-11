/**
 * 调整数组下标，奇数位置都为奇数，偶数位置都为偶数
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
        for (Integer K : a)
            System.out.print(K + " ");
    }

    /**
     * 设置奇数下标指针odd=0 , 偶数下标指针even=0. 然后从最后一个元素开始
     * 遇到奇数则交换到奇数下标那个位置的，遇到偶数就交换到偶数位置，在更新奇数偶数指针
     * 知道odd或者even最后遇到了遍历位置
     */
    private static void fun(int[] a, int n) {
        if (n <= 1)
            return;
        int odd = 1;
        int even = 0;
        while (odd < n && even < n) {
          int t = a[n-1]%2;
          if(t==1){
              swap(a,n-1,odd);
              odd += 2;
          }else{
              swap(a,n-1,even);
              even +=2;
          }


        }
    }

    private static void swap(int[] a, int i, int k) {
        int t = a[i];
        a[i] = a[k];
        a[k] = t;
    }


}
