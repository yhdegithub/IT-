// 打印最长递增子序列，要求是字典序最小的

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        a = fun(a, n);
        for (Integer i : a)
            System.out.print(i + " ");
    }

    /**
     * 难点主要有两个，一个是O(NLogN)的时间复杂度， 第二个就是打印排序最小的路径。
     * 1） 我们构造一个辅助数组end[]，end[i]用来保存当前最长的子序列成立的最小值元素，每次使用二分法判断插入位置
     * 2）路径最小。这个必须从右往左倒推，比如有a[i]、a[j]都满足子序列递增成立，我们再遍历一次获取当中的最小值。注意下遍历过程那里的证明
	      太神奇了
     */
    private static int[] fun(int[] a, int n) {
        if (n <= 0)
            return null;
        if (n == 1)
            return a;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int end[] = new int[n];
        end[0] = a[0];
        // end[0..right]都是满足递增序列的最小值，但并非最终结果哈
        int left = 0;
        int right = 0;
        // 先求最大递增子序列，获得end[] 和dp[]
        for (int i = 1; i < n; i++) {
            // 使用二分法查找end[]中的插入位置
            int l = 0, r = right;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (end[m] > a[i]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            // 更新end[]中某个数值，如果是新增非代替的话，还要更新right
            end[l] = a[i];
            if (l > right)
                right = l;
            // 更新dp[]
            dp[i] = l + 1;
        }
        // 根据获取的dp[]和end[]来打印路径
        int len = right + 1;
        int res[] = new int[len];
        int index = right;
        int next = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            //满足该条件求得的序列就是目标LIS。假设已知LIS最后一个数字（其实就是minTail中最后一个非0值
            //通过该判断求LIS前一个数值？（首先该条件为nums[k]是LIS倒数第二个数值的充分条件，但还需证明由该条件得到的LIS按字典排序最小）。假设除了k满足该条件，
            //还有i，j...满足，那么i，j...不可能在k之后（因为倒着遍历nums），所以推出num[i,j,...]必然大于nums[k]。绝不可能小于或者等于，否则可以推出dp[k]==index+2
            if (a[i] <= next && dp[i] == index + 1) {
                res[index] = a[i];
                next = res[index];
                 index--;
            }

        }

    return res;
    }


}