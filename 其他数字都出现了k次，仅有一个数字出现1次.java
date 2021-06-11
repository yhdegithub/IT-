import java.lang.reflect.Array;
import java.util.Scanner;

// 其他数字都出现了k次，仅有一个数字出现1次，找出这个数
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k=sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] =sc.nextInt();
        /**
         * 通过对32位二进制的每个数进行判断出现0,1的次数是否是k的整数倍，即可得到目标数在
         * 该位上的0，还是1
         */
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for(int j=0;j<32;j++){
            int cnt = 0;
            for(int i =0;i<n;i++){
                int t = (a[i] >> j ) & 1;
                if(t==1)
                    cnt++;
            }
            //本来该有k的整数个0，k的整数个1的。 出问题就是那个仅出现1次的那个值
            if(cnt%k == 1)
                res  = res | (1<<j);

        }
        System.out.println(res);

    }


}

