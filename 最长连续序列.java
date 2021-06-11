// 最长连续序列

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
     * 用一个set保存数字，当遍历到一个数字时候，分别向上向下遍历，取得范围值， 注意删除遍历过的值，这样可以保证时间
     * 大大缩减
     */
    private static int fun(int[] a, int n) {
        if (n <= 1)
            return 1;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(a[i]);
        for (int i = 0; i < n; i++) {
            if (!set.contains(a[i]))
                continue;
            int cur = 1;  //当下连续个数
            int up = a[i]+1;
            int down = a[i] -1;
            while(set.contains(up)){
                cur++;
                set.remove(up);
                up++;
            }
            while(set.contains(down)){
                cur++;
                set.remove(down);
                down--;
            }
            max = Math.max(max,cur);

        }

        return max;

    }


}