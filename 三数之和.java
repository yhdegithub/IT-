import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), num = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        for (int k = 0; k < n - 2; k++) {
           if(k>0 && a[k]==a[k-1]){
               continue;
           }
            int target = num - a[k];
            int i = k + 1, j = n - 1;
            while (i < j) {
                int judge = a[i] + a[j];
                if (judge == target) {
                    //if (a[j]==0 ||a[k]==n-1 ||a[i] != a[i-1])
                     if(a[i]!=a[i-1])  
                    System.out.println(a[k] + " " + a[i] + " " + a[j]);
                    i++;
                    j--;
                } else if (judge > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
    }
}
