/**
 *
 * 
 *    1) 本题考查亦或操作， 两数字相同则异或结果为0 ， 0异或任意一个数字，都得该数字
 *    2）扩展版本： 其他数字数字出现3次， 找出出现1次的那个：
 *       需要比较每个数字的32位二进制，某个数位必定出现1的次数为3K +1;
 */

import java.sql.Array;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {
        // Main m = new Main();
      Scanner sc = new Scanner(System.in);
      int  n= sc.nextInt() ;
      int res = 0;
     //int a[]  = new int[n];
      for(int i =0;i<n;i++){
       res  =  res ^ sc.nextInt();
      }
        System.out.println(res);
    }
}
//5 5 5 4 6 7
//2 2 2 3 6 7




// 扩展题
import java.util.*;
public class Solution {
      public int singleNumber(int[] A) {
        int n =A.length;
        char res[] = new char[32];
        int ans = 0;
        for(int i=0;i<32;i++){
            int flag = 1<<i;
            int count = 0;
            for(int j=0;j<n;j++)
                if( ( A[j] & flag ) != 0)
                    count++;
            if(count%3!=0)
               ans |= (1<<i) ;
        }
        
        return ans ;
    }
}