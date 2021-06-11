/**
 * 8 3
 * 4 3 5 4 3 3 6 7
 * 使用一个双端队列模拟操作，当前值从末尾插入，注意队列中存储的是数组的下标
 */

import java.sql.Array;
import java.util.*;
import java.util.jar.JarOutputStream;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int a[] = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        m.slideWindom(a, k, n);
        m.show(a);
    }
//  链表里面保存的是下标，需要打印的是下标对应的数组
    public void show( int a[]){
        for(int i=0;i<list.size()-1;i++)
            System.out.print(a[list.get(i)] + " ");
        System.out.println(a[list.get(list.size()-1)]);
    }



    static  List<Integer> list;

    public void slideWindom(int a[], int k, int n) {
        list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i < k) {
                while (!queue.isEmpty() && a[queue.peekLast()] <= a[i])
                    queue.pollLast();
                queue.offerLast(i);              // 存的是数组小组，方便滑动
            } else {
                list.add(queue.peekFirst());
                if(i-queue.peekFirst()==k)
                    queue.removeFirst();
                while (!queue.isEmpty() && a[queue.peekLast()]  <= a[i])
                    queue.pollLast();
                queue.offerLast(i);
            }


        }
        list.add(queue.peekFirst());
    }
}
//5 5 5 4 6 7
//2 2 2 3 6 7