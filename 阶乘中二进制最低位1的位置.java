/**
 * 阶乘结果的二进制的最低位的1在那个位置
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
        long n = sc.nextLong();
        System.out.println(fun(n));
    }

    /**
     *  3 * 5 * 7 * 11.....都是奇数。所以最低位0位就是1.但是由于要乘以2所以，有多少个2的因子，就左移多少位
     */
    private static long fun(long n) {
     if(n<=1)
         return 0;
     if(n==2)
         return 1;
      long res = 0;
      while(n>0){
          res += n/2;
          n = n/2;
      }
   return  res;
    }


}
