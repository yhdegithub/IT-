import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      int n =sc.nextInt();
      int a[][] =new int[n][n];
      for(int i=0;i<n;i++)
          for(int j=0;j<n;j++)
              a[i][j] =sc.nextInt();

          //对角线对着
        for(int i=0;i<n;i++)
            for(int j=0;j<i;j++)
                swap1(a,i,j);
       
            //竖直对折
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int t = a[i][j];
                a[i][j] = a[i][n-1-j];
                a[i][n-1-j] = t;

            }

        }
      show(a,n);
    }
    public static  void show(int a[][],int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
   public static void swap1(int a[][],int i, int j){
       int t = a[i][j];
       a[i][j] = a[j][i];
       a[j][i] =t;
   }

}