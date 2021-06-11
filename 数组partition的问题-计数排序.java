/**
 * 计数排序，仅此而已，不要求稳定
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int b[] = new int[3];
        for (Integer i : a)
            b[i]++;
        for (int i = 0; i <= 2; i++) {
            while (b[i] > 0) {
                b[i] = b[i] - 1;
                System.out.print(i + " ");
            }
           
        }
    }
}