import java.util.Scanner;

// 返回两个数中较大的那一个值
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int res = a - b;
        /** 使用位运算判断最高位为0,1
         *  1）a>=b   res>=0   sign 为 0  ， 异或1一次得1,即为d
         *  2）a<b    res<0    sign 为 1  ， 异或1一次得0,即为d
         */
        int sign = ((res >> 31) & 1) ;
        int d =  sign ^1;
        int result =  a *d + b * sign;
        System.out.println(result);
    }

}


// 还有一种方法  a - (a-b) * 差值最高位为0,1