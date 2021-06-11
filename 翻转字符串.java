import java.lang.reflect.Array;
import java.util.Scanner;

// 其他数字都出现了k次，仅有一个数字出现1次，找出这个数
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine().toString().toString();
        if(n.startsWith("-"))
            n = n.substring(1);
        int k = n.length();
        int i=0,j=k-1;
        char ch[]=  n.toCharArray();
        while(i<j){
            if(ch[i]!=ch[j]){
                System.out.println("No");
                return;
            }
            i++;
            j--;
        }
        System.out.println("Yes");

        }

    }




import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String chas = sc.next();
        System.out.println(chas.substring(size)+chas.substring(0,size));
    }
}