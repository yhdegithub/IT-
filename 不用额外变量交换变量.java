/**
 * 8 3
 * 4 3 5 4 3 3 6 7
 * 使用一个双端队列模拟操作，当前值从末尾插入，注意队列中存储的是数组的下标
 */

import java.sql.Array;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {
        // Main m = new Main();
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt() ,b = sc.nextInt();
      // 交换两个数字，不用额外变量
        a  = a+b;
        b = a-b;
       a = a-b;
        System.out.println( a + " " +b);
    }
}
//5 5 5 4 6 7
//2 2 2 3 6 7