//5
//11 7 5 7 7

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int times = 1;

        int a[] = new int[n];
        if (n == 0)
            System.out.println(-1);
        
        if (n == 1)
            System.out.println(sc.nextInt());
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int res = a[0];
        for (int i = 1; i < n; i++) {
            if (times == 0) {
                times = 1;
                res = a[i];
                continue;
            }
            if (res == a[i])
                times++;
            else
                times--;
        }
        int cnt = 0;
        for (Integer j : a)
            if (j == res)
                cnt++;
        if (cnt > n / 2)
            System.out.println(res);
        else
            System.out.println(-1);

    }

}