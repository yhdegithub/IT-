/**
 * 数组排序之后的相邻值的最大差值
 */

import java.io.*;
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
     * 采用桶排序的思想
     * 1）遍历得到max, min，然后取 N+1 个桶存放所有数组， 每个桶的范围大小是 range = （max - min）/ N.那么第0号桶，存放元素[ min , min + range).任意一个数字num
     * 应该存放到第  （num -min）* N / (max - min) 号桶
     * 2） 由于同一个桶之间的差距小于range。 N+1个桶必定含有空桶， 所以最大的gap就来自于空桶前的最大值和空桶后第一个非空桶的最小值
     */
    private static int fun(int[] a, int n) {
        if (a== null || n <= 1)
            return 0;
        int res = 0;
        int max = a[0], min = a[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        // 如果只有1个桶
        if(max == min)
            return 0;
        //存放第i号桶是否有数据
        boolean hasNum[] = new boolean[n + 1];
        // i号桶的最值
        int maxs[] = new int[n + 1];
        int mins[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // 根据桶的编号，设置是否有数字、最大值最小值,可能有溢出.不这样写没法通过
          //  int num = (a[i] - min) * n / (max - min);
            int num = getNum(a[i],n,min,max);
           // 该桶可能还没有数字
            if(hasNum[num]){
               maxs[num] = Math.max(maxs[num], a[i]);
               mins[num] = Math.min(a[i], mins[num]);
           }else{
                maxs[num] =a[i];
                mins[num] = a[i];
           }

            hasNum[num] = true;
        }
        // 找到第一个非空的桶
        int k = 0;
        int lastNoEmpty = 0;
        while (k <= n) {
            if (!hasNum[k]) {
                k++;
            } else {
                lastNoEmpty = k;
                break;
            }

        }
        //  前后非空桶计算最大gap
        k++;
        for (; k <= n; k++) {
            if (hasNum[k]) {
                int diff = mins[k]- maxs[lastNoEmpty];
                res = Math.max(diff,res);
                lastNoEmpty = k;

            }
        }

        return res;
    }

    private static int getNum(long  num, long n, long min, long max) {
        return  (int)(  (num-min) *n / (max -min)     );
    }


}
