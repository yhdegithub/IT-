
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // 实现函数
        System.out.println(maxLength(a, k));

    }

    /**
     * 子数组和为给定值。 使用dp[i]代表a[0] + ......a[i] 。那么
     * sum(i.....j) =  dp[j] - d[i-1].
     * 现在要sum(i...j)为规定值k, 那么 dp[i-1] 就要为 dp[j] -k. 我们可以使用一个map来保存dp[i],value是最早出现该值的地方
     *
     * @param a
     * @param n
     * @return
     */
   public static int maxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1); // important
		int len = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - k)) {
				len = Math.max(i - map.get(sum - k), len);
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
	}


}



