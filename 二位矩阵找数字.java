import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();
            if(find(a,m,n,k))
                System.out.println("Yes");
            else
        System.out.println("No");
    }

    public static boolean find(int a[][], int m, int n, int k) {
        if (a == null || m == 0 || n == 0)
            return false;
        int i = 0, j = n - 1;
        while (i>=0 && i<m && j<n && j>=0){
            if(a[i][j]==k)
                return true;
            else if(a[i][j]>k){
                j--;
            }
            else{
                i++;
            }
        }

return false;
    }

}