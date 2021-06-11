import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if(n<=4){
            System.out.println(0);
            return;
        }

        long cnt =0;
        long i =5;
        while((n/i)!=0){
            cnt += n/i;
            i = i*5;
        }
        System.out.println(cnt);
    }
}