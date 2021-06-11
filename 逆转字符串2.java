
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toString();
       fun(s);
    }

    private static boolean fun(String s) {
        if(s==null || s.length()<=1)
            System.out.println(s);
        String ss[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb = new StringBuilder(ss[i]);
            sb.reverse();
            res.append(sb.toString()+ " ");
        }
        System.out.println(res.substring(0,res.length()-1));
        return true;
    }


}



