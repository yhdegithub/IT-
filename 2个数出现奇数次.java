import java.lang.reflect.Array;
import java.util.Scanner;

// 两个数出现奇数次
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int num=-1;
        for (int j = 0; j < 32; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                int t = (a[i] >> j & 1);
                if (t == 1)
                    count++;
            }
            if (count % 2 != 0) {
                num = j;
                break;
            }
        }
        //
        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++) {
            if (((a[i] >> num) & 1) == 1)
                res1 = res1 ^ a[i];
            else
                res2 = res2 ^ a[i];
        }
        if(res1>res2)
            System.out.println(res2 + " " +res1);
        else
            System.out.println(res1+ " " +res2);

    }


}

