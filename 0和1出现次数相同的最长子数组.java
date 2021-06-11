
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // 实现函数
        for(int i=0;i<n;i++){
            if(a[i]==0)
                a[i] = -1;
        }
        int k = 0;
        System.out.println(fun(a, n, k));

    }

    /**
     * 把0换成-1， 这样就成了求和为0的子数组的最大长度
     *
     * @param a
     * @param n
     * @param k
     * @return
     */
    private static int fun(int[] a, int n, int k) {
        if (n <= 0)
            return 0;
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == k) {
                res = i + 1;
                map.put(sum, i);
                continue;
            }
            if(map.containsKey(sum- k)){
                res =  Math.max(res,i- map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return res;
    }


}



