/**
 * 删除链表中重复出现的值
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.fun();
    }

    public void fun() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Node dump = new Node(-1);
        Node tail = dump;
        // 建表
        for (int i = 0; i < m; i++) {
            Node cur = new Node(sc.nextInt());
            tail.next = cur;
            tail = cur;
        }
        Node pre = dump, cur = dump.next;
        HashSet<Integer> set = new HashSet<>();
        while (cur != null) {
            if (!set.contains(cur.val)){
                set.add(cur.val);
                pre= cur;
                cur = cur.next;
            }

            else{
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;

            }

        }

        cur=dump.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }


    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}