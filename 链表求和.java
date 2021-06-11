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
        int m = sc.nextInt(), n = sc.nextInt();
        Node dump = new Node(-1);
        Node tail = dump;
        // 头插法转置建表
        for (int i = 0; i < m; i++) {
            Node cur = new Node(sc.nextInt());
            cur.next = dump.next;
            dump.next = cur;
        }
        Node head1 = dump.next;
        dump = new Node(-1);
        for (int i = 0; i < n; i++) {
            Node cur = new Node(sc.nextInt());
            cur.next = dump.next;
            dump.next = cur;
        }
        Node head2 = dump.next;
        int cnt = 0;
        dump = new Node(-1);
        Node pre = dump;
        while (head1 != null || head2 != null) {
            int num = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + cnt;
            int val = num % 10;
            cnt = num / 10;
            Node cur = new Node(val);
            cur.next = dump.next;
            dump.next = cur;
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        if (cnt != 0) {
            Node cur = new Node(cnt);
            cur.next = dump.next;
            dump.next = cur;
        }
        Node head = dump.next;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
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