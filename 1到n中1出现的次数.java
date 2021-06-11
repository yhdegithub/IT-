
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 判断数位为0， 1 ，else 三种情况即可
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);

        long res = 0;
        long nCopy = n;
        long count = 1;

        while (nCopy != 0){
            long val = nCopy % 10;
            long div = (long) (nCopy / 10);

            if(val < 1){
                res += div * count;
            }else if(val == 1){
                res += div * count + (n % count) + 1;
            }else{
                res += (div + 1) * count;
            }

            nCopy = div;

            count *= 10;
        }

        System.out.println(res);


    }


}